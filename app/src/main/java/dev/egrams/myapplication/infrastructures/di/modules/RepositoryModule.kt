package dev.egrams.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import dev.egrams.data.persistences.mappers.UserDataMapper
import dev.egrams.data.persistences.repositories.UserRepository
import dev.egrams.myapplication.infrastructures.persistences.api.UserApiPersistence
import javax.inject.Named

@Module
class RepositoryModule {
    @Provides @Named("APIUserRepository")
    fun provideUserApiRepository(persistence: UserApiPersistence, dataMapper: UserDataMapper): UserRepository {
        return UserRepository(persistence, dataMapper)
    }
}