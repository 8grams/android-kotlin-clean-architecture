package dev.egrams.myapplication.infrastructures.di.components

import dagger.Component
import dev.egrams.myapplication.infrastructures.di.modules.*
import dev.egrams.myapplication.ui.presenters.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidModule::class,
    ApiModule::class,
    MapperModule::class,
    PersistenceModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {
    fun inject(mainPresenter: MainPresenter)

    companion object {
        fun getComponent(): AppComponent {
            return DaggerAppComponent.create()
        }
    }
}