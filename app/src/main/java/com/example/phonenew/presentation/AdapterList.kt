package com.example.phonenew.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.phonenew.R
import com.example.phonenew.data.local.list.CellPhoneEntity
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
            binding.tvPriceItem.text = "$ ${cellPhone.price}"
            binding.cvItem.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("id", cellPhone.id.toString())
                Navigation.findNavController(binding.root).navigate(R.id.action_firstFragmentList_to_secondFragmentDetail, bundle)
            }
        }
    }
}