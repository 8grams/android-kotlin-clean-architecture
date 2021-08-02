package dev.egrams.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import dev.egrams.data.persistences.repositories.UserRepository
import dev.egrams.usecases.GetUsers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Named

@Module
class UseCaseModule  {
    @Provides @Named("APIGetUserUseCase")
    fun provideGetUsersUseCase(@Named("APIUserRepository") userRepository: UserRepository, compositeDisposable: CompositeDisposable): GetUsers {
        return GetUsers(userRepository, compositeDisposable, AndroidSchedulers.mainThread())
    }
}