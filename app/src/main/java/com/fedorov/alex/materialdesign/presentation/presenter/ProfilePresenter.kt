package com.fedorov.alex.materialdesign.presentation.presenter

import com.fedorov.alex.materialdesign.presentation.view.ProfileView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class ProfilePresenter : MvpPresenter<ProfileView>() {
    fun onClickShowProgressBar() {
        viewState.showProgressBar()

        GlobalScope.launch(Dispatchers.Main) {
            // For example, after 5 sec hide progress bar.
            startTimer()
            viewState.hideProgressBar()
        }
    }

    fun onClickHideProgressBar() {
        viewState.hideProgressBar()
    }

    fun onClickOpenSettings(){
        viewState.openSettings()
    }

    private suspend fun startTimer() = withContext(Dispatchers.IO) {
        Thread.sleep(5000)
    }
}

