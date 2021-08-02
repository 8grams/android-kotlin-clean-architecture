package dev.egrams.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import dev.egrams.myapplication.infrastructures.api.UserApi
import dev.egrams.myapplication.infrastructures.persistences.api.UserApiPersistence

@Module
class PersistenceModule {
    @Provides
    fun provideUserApiPersistence(service: UserApi): UserApiPersistence {
        return UserApiPersistence(service)
    }
}