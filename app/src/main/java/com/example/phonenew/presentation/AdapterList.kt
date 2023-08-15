package com.example.phonenew.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.phonenew.data.local.CellPhoneEntity
import com.example.phonenew.databinding.ItemBinding

class AdapterList : RecyclerView.Adapter<AdapterList.ViewHolder>() {
    lateinit var itemBinding: ItemBinding
    private val listOfCellPhones = mutableListOf<CellPhoneEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterList.ViewHolder {
        itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AdapterList.ViewHolder, position: Int) {
        val cellPhone = listOfCellPhones[position]
        holder.bind(cellPhone)
    }

    override fun getItemCount(): Int {
        return listOfCellPhones.size
    }
    fun setData(cellPhones: List<CellPhoneEntity>){
        this.listOfCellPhones.clear()
        this.listOfCellPhones.addAll(cellPhones)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cellPhone: CellPhoneEntity) {
            binding.imageItem.load(cellPhone.image)
            binding.tvNameItem.text = cellPhone.name
            binding.tvPriceItem.text = cellPhone.price.toString()
        }
    }
}