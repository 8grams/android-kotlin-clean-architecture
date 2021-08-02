package dev.egrams.myapplication.infrastructures.api

import dev.egrams.data.payload.api.user.GetUsersApiResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface UserApi {
    @GET("db")
    fun getUsers(@QueryMap queries: Map<String, String>): Observable<GetUsersApiResponse>
}