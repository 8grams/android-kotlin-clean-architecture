package dev.egrams.myapplication.ui.views

import dev.egrams.domain.User

interface MainView {
    interface View: BaseView<Presenter> {
        fun onSuccessLoadUsers(users: List<User>)
    }

    interface Presenter: BasePresenter {
        fun onLoadUsers(params: Map<String, String>)
    }
}