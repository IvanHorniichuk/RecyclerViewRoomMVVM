package com.ivan.horniichuk.signature.statistic.basics.koin

import android.content.Context
import com.ivan.horniichuk.bookrepotestroom.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

object JavaKoin {

    val TAG="JavaKoin"

    @JvmStatic
    fun startKoinApplication(context: Context) {
        if (GlobalContext.getOrNull() == null) {
            startKoin {
                androidContext(context)
                modules(koinModule)
                printLogger()
            }
        }
    }

    @JvmStatic
    fun closeKoinApplication() {
        stopKoin()
    }

}