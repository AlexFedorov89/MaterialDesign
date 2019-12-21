package com.fedorov.alex.materialdesign.presentation.view

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface LoginView : MvpView {
    fun onLoginSuccess()
    fun onLoginFail()
    fun closeApp()
}