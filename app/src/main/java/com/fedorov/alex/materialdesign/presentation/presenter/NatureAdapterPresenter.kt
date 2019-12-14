package com.fedorov.alex.materialdesign.presentation.presenter

import com.fedorov.alex.materialdesign.interactor.ListInteractor
import com.fedorov.alex.materialdesign.model.RepositoryNature
import com.fedorov.alex.materialdesign.presentation.IAdapter
import com.fedorov.alex.materialdesign.presentation.view.NatureListView
import com.fedorov.alex.materialdesign.ui.items.ItemsRowConcarent
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class NatureAdapterPresenter : MvpPresenter<NatureListView>(), IAdapter {
    private val repository = RepositoryNature()
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