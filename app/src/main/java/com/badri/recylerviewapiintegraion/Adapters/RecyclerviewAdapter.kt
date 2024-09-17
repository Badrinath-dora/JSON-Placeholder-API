package com.badri.recylerviewapiintegraion.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.badri.recylerviewapiintegraion.databinding.RecyclerViewBinding
import com.badri.recylerviewapiintegraion.model.RecyclerviewData
import com.badri.recylerviewapiintegraion.model.RecyclerviewDataItem

class RecyclerviewAdapter : RecyclerView.Adapter<RecyclerviewAdapter.RecyclerviewHolder>() {

    private var data: List<RecyclerviewDataItem> = listOf()
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): RecyclerviewHolder {
        val binding =
            RecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerviewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerviewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun submitList(dataSubmitting: RecyclerviewData) {
        data = dataSubmitting
        notifyDataSetChanged()
    }

    class RecyclerviewHolder(private val binding: RecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(recyclerviewDataItem: RecyclerviewDataItem) {
            binding.txtTitle.text = recyclerviewDataItem.title
            binding.txtBody.text = recyclerviewDataItem.body
            binding.txtUserId.text = "User Id : ${recyclerviewDataItem.userId}"
            binding.txtId.text = "Id : ${recyclerviewDataItem.id}"
        }
    }

}