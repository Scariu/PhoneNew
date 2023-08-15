package com.example.phonenew.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.phonenew.R
import com.example.phonenew.databinding.FragmentSecondDetailBinding


private const val ARG_PARAM1 = "param1"

class SecondFragmentDetail : Fragment() {
lateinit var binding: FragmentSecondDetailBinding
private val viewModel: CellPhoneViewModel by activityViewModels()

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_second_detail, container, false)
    }
}