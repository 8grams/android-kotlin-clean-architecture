package dev.egrams.myapplication.data

import dev.egrams.myapplication.di.TestComponent
import dev.egrams.myapplication.infrastructures.api.UserApi
import dev.egrams.myapplication.infrastructures.persistences.api.SummaryApiPersistence
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.*
import javax.inject.Inject

class SummaryPersistenceTest {

    init {
        TestComponent.getComponent().inject(this)
    }

    @Inject lateinit var summaryApiPersistence: SummaryApiPersistence

    @Test
    fun `API queryData should always return SummaryApiQueryResult`() {
        val apiService = mock(UserApi::class.java)
        `when`(apiService.listRepos()).then {
            Observable.create<dev.egrams.data.SummaryApiQueryResult> {  }
        }
        val sap =
            SummaryApiPersistence(
                apiService
            )
        Assert.assertSame(true, sap.queryData() is Observable<dev.egrams.data.SummaryQueryResult>)
    }

    @Test
    fun `API queryData using RxJava should works properly`() {
        val subscriber = TestObserver<dev.egrams.data.SummaryQueryResult>()
        summaryApiPersistence.queryData().subscribe(subscriber)

        subscriber.assertComplete()
    }
}