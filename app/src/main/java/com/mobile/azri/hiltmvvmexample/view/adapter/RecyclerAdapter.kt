package com.mobile.azri.hiltmvvmexample.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.azri.hiltmvvmexample.databinding.RecyclerRowBinding
import com.mobile.azri.hiltmvvmexample.model.RecyclerData

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    private lateinit var binding: RecyclerRowBinding

    private var listData = ArrayList<RecyclerData>()

    fun setListData(listData: ArrayList<RecyclerData>){
        this.listData = listData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = RecyclerRowBinding.inflate(inflater,parent,false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        listData[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return listData.size

    }

    class RecyclerViewHolder(recyclerBinding : RecyclerRowBinding): RecyclerView.ViewHolder(recyclerBinding.root) {

        private var binding = recyclerBinding

        @SuppressLint("CheckResult")
        fun bind(data : RecyclerData){
            binding.tvName.text = data.name
            binding.tvDesc.text = data.description

            Glide.with(binding.imgThumb)
                .load(data.owner?.avatar_url)
                .into(binding.imgThumb)
        }

    }
}