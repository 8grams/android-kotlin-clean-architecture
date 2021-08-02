package dev.egrams.myapplication.data

import dev.egrams.myapplication.di.TestComponent
import org.junit.Assert
import org.junit.Test
import javax.inject.Inject

class SummaryDataMapperTest {

    init {
        TestComponent.getComponent().inject(this)
    }

    @Inject lateinit var dataMapper: dev.egrams.data.SummaryDataMapper

    @Test
    fun `convertFromDb return valid data` () {
        var exampleDbResult = dev.egrams.data.SummaryDbQueryResult(1, "Surabaya", 50.0f, 60.0f)
        var domainResult = dataMapper.convert(exampleDbResult)

        Assert.assertSame(exampleDbResult.city_name, domainResult.city)
    }
}