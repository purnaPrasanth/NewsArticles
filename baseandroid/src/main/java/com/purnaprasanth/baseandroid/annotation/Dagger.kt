package com.purnaprasanth.baseandroid.annotation

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Qualifier
import kotlin.reflect.KClass

/**
 * Created by purna on 2019-11-03
 **/

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)