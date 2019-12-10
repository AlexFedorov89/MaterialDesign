package com.fedorov.alex.materialdesign.presentation.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface LoginView : MvpView {
    fun onLoginSuccess()
    fun onLoginFail()
    fun closeApp()
}