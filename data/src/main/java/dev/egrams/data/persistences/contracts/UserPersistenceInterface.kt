package dev.egrams.data.persistences.contracts

import dev.egrams.data.payload.contracts.GetUsersResponseInterface
import io.reactivex.rxjava3.core.Observable;

interface UserPersistenceInterface {
    fun getUsers(params: Map<String, String>): Observable<out GetUsersResponseInterface>
}