package dev.egrams.data.persistences.mappers

import dev.egrams.data.payload.api.user.GetUsersApiResponse
import dev.egrams.data.payload.contracts.GetUsersResponseInterface
import dev.egrams.domain.User

class UserDataMapper {

    fun convertUserList(result: GetUsersResponseInterface?): List<User> {
        val response = mutableListOf<User>()

        if (result is GetUsersApiResponse) {
            result.data.forEach {
                response.add(
                    User(it.name, it.email, it.phone)
                )
            }
        }
        return response
    }
}