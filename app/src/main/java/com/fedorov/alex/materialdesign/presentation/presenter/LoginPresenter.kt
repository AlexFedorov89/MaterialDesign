package com.fedorov.alex.materialdesign.presentation.presenter

import com.fedorov.alex.materialdesign.presentation.view.LoginView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {
    fun checkLogin(s: String){
        if (s.isNotEmpty()) {
            viewState.onLoginSuccess()
        } else {
            viewState.onLoginFail()
        }
    }

    fun closeApp(){
        viewState.closeApp()
    }
}