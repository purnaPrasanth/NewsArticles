package com.purnaprasanth.articles.articles

import com.purnaprasanth.base.AppRxSchedulers
import com.purnaprasanth.base.ext.notOfType
import com.purnaprasanth.base.mvi.MviInterator
import com.purnaprasanth.baseandroid.BaseViewModel
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.functions.BiFunction
import javax.inject.Inject

/**
 * Created by purna on 2019-11-08
 **/

class ArticlesViewModel @Inject constructor(
    appRxSchedulers: AppRxSchedulers,
    private val interactor: MviInterator<ArticlesAction, ArticlesResult>
) : BaseViewModel<ArticlesIntent, ArticlesViewState>(appRxSchedulers) {

    private val intentFilter: ObservableTransformer<ArticlesIntent, ArticlesIntent>
        get() = ObservableTransformer { intents ->
            intents.publish { shared ->
                Observable.merge(
                    shared.ofType(ArticlesIntent::class.java).take(1),
                    shared.notOfType(ArticlesIntent.InitialIntent::class.java)
                )
            }
        }

    override fun compose() = intentsSubject
        .compose(intentFilter)
        .map(this::actionFromIntent)
        .compose(interactor.actionInteractor())
        // Cache each state and pass it to the reducer to create a new state from
        // the previous cached one and the latest Result emitted from the action processor.
        // The Scan operator is used here for the caching.
        .scan(ArticlesViewState.initial(), reducer)
        // When a reducer just emits previousState, there's no reason to call render. In fact,
        // redrawing the UI in cases like this can cause jank (e.g. messing up snackbar animations
        // by showing the same snackbar twice in rapid succession).
        .distinctUntilChanged()
        // Emit the last one event of the stream on subscription
        // Useful when a View rebinds to the ViewModel after rotation.
        .replay(1)
        // Create the stream on creation without waiting for anyone to subscribe
        // This allows the stream to stay alive even when the UI disconnects and
        // match the stream's lifecycle to the ViewModel's one.
        .autoConnect(0)

    private fun actionFromIntent(intent: ArticlesIntent): ArticlesAction {
        return when (intent) {
            is ArticlesIntent.InitialIntent -> ArticlesAction.LoadArticlesAction(ArticleFiler.Science)
            is ArticlesIntent.RefreshArticlesIntent -> ArticlesAction.RefreshArticlesAction(intent.newFilter)
            is ArticlesIntent.ChangeFilterIntent -> ArticlesAction.LoadArticlesAction(intent.newFilter)
        }
    }

    companion object {
        val reducer = BiFunction { previousState: ArticlesViewState, result: ArticlesResult ->
            when (result) {
                is ArticlesResult.LoadArticlesResult -> when (result) {
                    is ArticlesResult.LoadArticlesResult.Success -> {
                        previousState.copy(
                            isLoading = false,
                            articles = result.tasks,
                            articleFilter = result.articleFiler
                        )
                    }
                    is ArticlesResult.LoadArticlesResult.Failure -> previousState.copy(
                        isLoading = false,
                        error = result.error
                    )
                    is ArticlesResult.LoadArticlesResult.Loading -> previousState.copy(isLoading = true)
                }
                is ArticlesResult.RefreshArticlesResult -> when (result) {
                    is ArticlesResult.RefreshArticlesResult.Success ->
                        previousState.copy(
                            isLoading = false,
                            articles = result.tasks,
                            articleFilter = previousState.articleFilter
                        )
                    is ArticlesResult.RefreshArticlesResult.Failure -> previousState.copy(
                        error = result.error,
                        isLoading = false
                    )
                    is ArticlesResult.RefreshArticlesResult.Loading -> previousState.copy(isLoading = true)
                }
            }
        }
    }
}