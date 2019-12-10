package com.fedorov.alex.materialdesign.presentation.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView : MvpView {
    @StateStrategyType(value = AddToEndSingleStrategy::class, tag = "SHOW_HIDE_PB")
    fun showProgressBar()
    @StateStrategyType(value = AddToEndSingleStrategy::class, tag = "SHOW_HIDE_PB")
    fun hideProgressBar()
}