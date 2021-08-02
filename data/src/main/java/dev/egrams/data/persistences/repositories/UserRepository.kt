package dev.egrams.data.persistences.repositories

import dev.egrams.data.payload.contracts.RepositoryInterface
import dev.egrams.data.persistences.contracts.UserPersistenceInterface
import dev.egrams.data.persistences.mappers.UserDataMapper
import dev.egrams.domain.User
import io.reactivex.rxjava3.core.Observable;

class UserRepository(private val persistence: UserPersistenceInterface, private val mapper: UserDataMapper): RepositoryInterface {
    fun getUsers(params: Map<String, String>): Observable<List<User>> {
        return persistence.getUsers(params).map {
            mapper.convertUserList(it)
        }
    }
}