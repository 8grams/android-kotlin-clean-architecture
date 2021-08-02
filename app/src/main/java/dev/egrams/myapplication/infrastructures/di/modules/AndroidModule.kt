package dev.egrams.myapplication.infrastructures.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import dev.egrams.myapplication.MyApplication
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AndroidModule {
    @Provides
    fun provideContext(): Context {
        return MyApplication.getInstance().applicationContext
    }

    @Provides @Singleton
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}