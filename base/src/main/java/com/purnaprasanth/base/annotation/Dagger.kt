package com.purnaprasanth.base.annotation

import javax.inject.Qualifier


/**
 * Created by purna on 2019-11-04
 **/

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class App

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class Main

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class Common

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class IO