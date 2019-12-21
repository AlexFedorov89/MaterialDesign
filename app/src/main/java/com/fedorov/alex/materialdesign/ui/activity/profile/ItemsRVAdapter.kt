package com.fedorov.alex.materialdesign.ui.activity.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fedorov.alex.materialdesign.R
import com.fedorov.alex.materialdesign.presentation.RVAdapter
import kotlinx.android.synthetic.main.rv_item.view.*


class ItemsRVAdapter(private val presenter: RVAdapter) :
    RecyclerView.Adapter<ItemsRVAdapter.ItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return presenter.getRepositoriesRowsCount()
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder)
    }

    inner class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        ItemsRowConcarent {

        override fun setTitle(position: Int, title: String) {
            when (position % 3) {
                0 -> itemView.itemImg.setImageResource(R.drawable.ic_picture_nature)
                1 -> itemView.itemImg.setImageResource(R.drawable.ic_picture_fruits)
                2 -> itemView.itemImg.setImageResource(R.drawable.ic_picture_vegetables)
            }
            itemView.itemText.text = title
        }
    }
}