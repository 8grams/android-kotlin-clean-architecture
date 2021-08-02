package dev.egrams.myapplication.ui.presenters

import dev.egrams.domain.User
import dev.egrams.myapplication.infrastructures.di.components.AppComponent
import dev.egrams.myapplication.ui.views.MainView
import dev.egrams.usecases.GetUsers
import io.reactivex.rxjava3.observers.DisposableObserver
import javax.inject.Inject
import javax.inject.Named

class MainPresenter (var view: MainView.View?): MainView.Presenter {
    @Inject @Named("APIGetUserUseCase") lateinit var getUsers: GetUsers

    init {
        AppComponent.getComponent().inject(this)
    }

    override fun onLoadUsers(params: Map<String, String>) {
        getUsers.getUsers(GetUsersObserver(), params)
    }

    override fun onDestroy() {
        view = null
        getUsers.dispose()
    }

    inner class GetUsersObserver: DisposableObserver<List<User>>() {
        override fun onComplete() {}
        override fun onNext(t: List<User>) {
            view?.onSuccessLoadUsers(t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }
}