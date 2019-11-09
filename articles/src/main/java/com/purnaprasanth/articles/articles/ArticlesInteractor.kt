package com.purnaprasanth.articles.articles

import com.purnaprasanth.base.AppRxSchedulers
import com.purnaprasanth.base.mvi.MviInterator
import com.purnaprasanth.newsarticles.data.repo.ArticleRepo
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by purna on 2019-11-09
 **/

@Singleton
class ArticlesInteractor @Inject constructor(
    private val articleRepo: ArticleRepo,
    private val appRxSchedulers: AppRxSchedulers
) : MviInterator<ArticlesAction, ArticlesResult> {

    private val loadArticlesProcessor =
        ObservableTransformer<ArticlesAction.LoadArticlesAction, ArticlesResult.LoadArticlesResult> { actions ->
            actions.flatMap { action ->
                articleRepo.getArticles(action.filter.value, true)
                    // Wrap returned data into an immutable object
                    .map { articles ->
                        ArticlesResult.LoadArticlesResult.Success(
                            articles,
                            action.filter
                        )
                    }
                    .cast(ArticlesResult.LoadArticlesResult::class.java)
                    /**
                     * Wrap any error into an immutable object and pass it down the stream without crashing.
                     * Because errors are data and hence, should just be part of the stream.
                     */
                    .onErrorReturn(ArticlesResult.LoadArticlesResult::Failure)
                    .subscribeOn(appRxSchedulers.ioScheduler)
                    .observeOn(appRxSchedulers.mainScheduler)
                    /**
                     * Emit an [ArticlesResult.LoadArticlesResult.Loading] event to notify the subscribers (e.g. the UI) we are
                     * doing work and waiting on a response.
                     * We emit it after observing on the UI thread to allow the event to be emitted
                     * on the current frame and avoid jank.
                     */
                    .startWith(ArticlesResult.LoadArticlesResult.Loading)
            }
        }

    private val refreshArticlesProcessor =
        ObservableTransformer<ArticlesAction.RefreshArticlesAction, ArticlesResult.RefreshArticlesResult> { actions ->
            actions.flatMap { action ->
                articleRepo.getArticles(action.filter.value, true)
                    // Wrap returned data into an immutable object
                    .map { articles ->
                        ArticlesResult.RefreshArticlesResult.Success(
                            articles
                        )
                    }
                    .cast(ArticlesResult.RefreshArticlesResult::class.java)
                    /**
                     * Wrap any error into an immutable object and pass it down the stream without crashing.
                     * Because errors are data and hence, should just be part of the stream.
                     */
                    .onErrorReturn(ArticlesResult.RefreshArticlesResult::Failure)
                    .subscribeOn(appRxSchedulers.ioScheduler)
                    .observeOn(appRxSchedulers.mainScheduler)
                    /**
                     * Emit an [ArticlesResult.RefreshArticlesResult.Loading] event to notify the subscribers (e.g. the UI) we are
                     * doing work and waiting on a response.
                     * We emit it after observing on the UI thread to allow the event to be emitted
                     * on the current frame and avoid jank.
                     */
                    .startWith(ArticlesResult.RefreshArticlesResult.Loading)
            }
        }

    override fun actionInteractor(): ObservableTransformer<ArticlesAction, ArticlesResult> =
        ObservableTransformer { actions ->
            actions.publish { shared ->
                Observable.merge(
                    // Match LoadTasksAction to loadTasksProcessor
                    shared.ofType(ArticlesAction.LoadArticlesAction::class.java)
                        .compose(loadArticlesProcessor),
                    // Match CompleteTaskAction to completeTaskProcessor
                    shared.ofType(ArticlesAction.RefreshArticlesAction::class.java)
                        .compose(refreshArticlesProcessor)
                )
            }
        }

}