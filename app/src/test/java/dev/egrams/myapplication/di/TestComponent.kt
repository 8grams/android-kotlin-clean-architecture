package dev.egrams.myapplication.di

import dagger.Component
import dev.egrams.data.SummaryDataMapper
import dev.egrams.myapplication.data.SummaryDataMapperTest
import dev.egrams.myapplication.data.SummaryPersistenceTest
import dev.egrams.myapplication.infrastructures.di.modules.ApiModule
import dev.egrams.myapplication.infrastructures.di.modules.PersistenceModule
import dev.egrams.myapplication.infrastructures.persistences.api.SummaryApiPersistence

@Component(modules = [PersistenceModule::class, ApiModule::class])
interface TestComponent {
    fun getDataMapper(): dev.egrams.data.SummaryDataMapper
    fun getSummaryApiPersistence(): SummaryApiPersistence

    fun inject(summaryDataMapperTest: SummaryDataMapperTest)
    fun inject(summaryPersistenceTest: SummaryPersistenceTest)

    companion object {
        fun getComponent(): TestComponent {
            return DaggerTestComponent.create()
        }
    }
}