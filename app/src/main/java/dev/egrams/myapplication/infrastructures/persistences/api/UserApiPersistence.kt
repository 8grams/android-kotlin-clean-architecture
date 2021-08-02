package dev.egrams.myapplication.infrastructures.persistences.api

import dev.egrams.data.payload.api.user.GetUsersApiResponse
import dev.egrams.data.persistences.contracts.UserPersistenceInterface
import dev.egrams.myapplication.infrastructures.api.UserApi
import io.reactivex.rxjava3.core.Observable

// get from api
class UserApiPersistence(private var userApi: UserApi): UserPersistenceInterface {
    override fun getUsers(params: Map<String, String>): Observable<GetUsersApiResponse> {
        return userApi.getUsers(params)
    }
}