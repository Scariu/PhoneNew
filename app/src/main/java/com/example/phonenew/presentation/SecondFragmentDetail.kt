package com.example.phonenew.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.phonenew.databinding.FragmentSecondDetailBinding


class SecondFragmentDetail : Fragment() {
    lateinit var binding: FragmentSecondDetailBinding
    private val viewModel: CellPhoneViewModel by activityViewModels()

    private var paramId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramId = it.getString("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondDetailBinding.inflate(layoutInflater)
        initComponents()
        return binding.root
    }

    private fun initComponents() {
        viewModel.getCellPhoneDetailsViewModel(paramId.toString().toLong())
        viewModel.cellPhoneDetailsLiveData(paramId.toString().toLong())
            .observe(viewLifecycleOwner) {
                if (it != null) {
                    binding.imageDetail.load(it.image)
                    binding.tvDetailName.text = it.name
                    binding.tvDetailPrice.text = "$ ${it.price}"
                    binding.tvDetailDescription.text = it.description
                    binding.tvDetailLastPrice.text = "$ ${it.lastPrice}"
                    if (!it.credit) {
                        binding.tvDetailCredit.text = "EFECTIVO"
                    } else {
                        binding.tvDetailCredit.text = "CREDITO"
                    }
                }
            }
    }
}