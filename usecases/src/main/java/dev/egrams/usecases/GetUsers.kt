package dev.egrams.usecases

import dev.egrams.data.persistences.repositories.UserRepository
import dev.egrams.domain.User
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

class GetUsers(private var repository: UserRepository,
                private var compositeDisposable: CompositeDisposable,
                private var observerScheduler: Scheduler) {
    fun getUsers(observer: DisposableObserver<List<User>>, params: Map<String, String>) {
         val observable = repository.getUsers(params)
            .subscribeOn(Schedulers.newThread())
            .observeOn(observerScheduler)

        compositeDisposable.add(observable.subscribeWith(observer))
    }

    fun dispose() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose();
        }
    }
}