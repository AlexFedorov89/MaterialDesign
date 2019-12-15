package com.fedorov.alex.materialdesign.presentation.presenter

import com.fedorov.alex.materialdesign.interactor.ListInteractor
import com.fedorov.alex.materialdesign.model.RepositoryVegetables
import com.fedorov.alex.materialdesign.presentation.IRVAdapter
import com.fedorov.alex.materialdesign.presentation.view.VegetablesListView
import com.fedorov.alex.materialdesign.ui.activity.profile.ItemsRowConcarent
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class VegetablesAdapterPresenter : MvpPresenter<VegetablesListView>(), IRVAdapter {
    private val repository = RepositoryVegetables()
    private val interactor = ListInteractor(repository)

    fun updateUI() {
        viewState.updateDataSet()
    }

    override fun onBindRepositoryRowViewAtPosition(
        position: Int,
        rowConcarent: ItemsRowConcarent
    ) {
        val repo: String = interactor.getItems()[position]
        rowConcarent.setTitle(position, repo)
    }

    override fun getRepositoriesRowsCount(): Int {
        return interactor.getItems().size
    }
}