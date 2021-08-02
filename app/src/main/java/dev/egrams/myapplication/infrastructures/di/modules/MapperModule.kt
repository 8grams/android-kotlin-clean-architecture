package dev.egrams.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import dev.egrams.data.persistences.mappers.UserDataMapper

@Module
class MapperModule {
    @Provides
    fun provideUserDataMapper(): UserDataMapper {
        return UserDataMapper()
    }
}