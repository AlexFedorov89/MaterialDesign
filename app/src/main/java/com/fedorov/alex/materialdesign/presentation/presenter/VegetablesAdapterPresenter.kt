package com.fedorov.alex.materialdesign.presentation.presenter

import com.fedorov.alex.materialdesign.interactor.ListInteractor
import com.fedorov.alex.materialdesign.model.RepositoryVegetables
import com.fedorov.alex.materialdesign.presentation.IAdapter
import com.fedorov.alex.materialdesign.presentation.view.VegetablesListView
import com.fedorov.alex.materialdesign.ui.items.ItemsRowConcarent
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class VegetablesAdapterPresenter : MvpPresenter<VegetablesListView>(), IAdapter {
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