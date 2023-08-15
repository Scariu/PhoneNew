package com.example.phonenew.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.phonenew.databinding.FragmentFirstListBinding


class FirstFragmentList : Fragment() {
    lateinit var binding: FragmentFirstListBinding
    private val viewModel: CellPhoneViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstListBinding.inflate(layoutInflater)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        viewModel.getCellPhonesViewModel()
        val adapter = AdapterList()
        binding.recyclerViewList.adapter = adapter
        viewModel.cellPhonesLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}