package com.fedorov.alex.materialdesign.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.fedorov.alex.materialdesign.R
import com.fedorov.alex.materialdesign.presentation.presenter.VegetablesAdapterPresenter
import com.fedorov.alex.materialdesign.presentation.view.VegetablesListView
import com.fedorov.alex.materialdesign.ui.items.ItemsRVAdapter
import kotlinx.android.synthetic.main.fragment_vegetables.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class VegetablesFragment : MvpAppCompatFragment(), VegetablesListView {
    @InjectPresenter
    internal lateinit var presenter: VegetablesAdapterPresenter

    private val adapter by lazy {
        ItemsRVAdapter(
            presenter
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vegetables, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
        rv_vegetables_list.layoutManager = GridLayoutManager(activity, 2)

        rv_vegetables_list.adapter = adapter
    }

    override fun updateDataSet() {
        adapter.notifyDataSetChanged()
    }
}