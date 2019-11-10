package com.purnaprasanth.buildSrc

import sun.misc.Version


/**
 * Created by viking_93 on 2019-11-07
 **/

object Libs {

    object Plugins {
        const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.pluginGradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val kotlinAndroidExtensions =
            "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}"
    }

    object Androidx {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val constraintLayout =
            "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
        const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recycleView}"
    }

    object LifeCycle {
        const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
        const val runner = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
        const val compiler = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    }

    object OkHttp {
        const val core = "com.squareup.okhttp3:OkHttp:${Versions.okHttp}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"
    }

    object Browser {
        const val browser = "androidx.browser:browser:${Versions.browser}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val mock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
        const val rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    }

    object Stetho {
        const val core = "com.facebook.stetho:stetho:${Versions.stetho}"
        const val okhttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
    }

    object Dagger {
        const val core = "com.google.dagger:dagger:${Versions.dagger2}"
        const val android = "com.google.dagger:dagger-android:${Versions.dagger2}"
        const val androidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger2}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger2}"
        const val androidSupportCompiler =
            "com.google.dagger:dagger-android-processor:${Versions.dagger2}"
    }

    object RxJava {
        const val java = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
        const val android = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    }

    object Glide {
        const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compile = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Junit {
        const val jUnit = "junit:junit:${Versions.jUnit}"
        const val atslJunit = "androidx.test.ext:junit:${Versions.atslExt}"
    }

    object Espresso {
        const val core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }
}