package com.sufajar.myrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sufajar.myrecyclerview.R
import com.sufajar.myrecyclerview.databinding.ListItemBinding
import com.sufajar.myrecyclerview.model.PemainBola

class RecyclearviewAdapter(private val context: Context,
                           private var data: List<PemainBola>?,
                           private val itemClick: OnClickListener
                           ): RecyclerView.Adapter<RecyclearviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       // val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text =  item?.nama
        holder.itemView.setOnClickListener{
            itemClick.detailData(item)
        }


    }

    override fun getItemCount(): Int = data?.size ?: 0

    inner class ViewHolder(val binding: ListItemBinding)
        :RecyclerView.ViewHolder(binding.root) {
            var foto = binding.image
        var nama = binding.txtnama

        }

    interface OnClickListener {
        fun detailData(item : PemainBola?)
    }

}