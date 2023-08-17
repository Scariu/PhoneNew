package com.example.phonenew.presentation

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.phonenew.R
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
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        viewModel.cellPhoneDetailsLiveData(paramId.toString().toLong())
            .observe(viewLifecycleOwner) {
                if (it != null) {
                    val asunto = "Consulta ${it.name} id ${it.id}"
                    val message =
                        "Hola, \nVi la propiedad ${it.name} de código ${it.id} y me gustaría que me contactaran a este correo o al siguiente número ____________. \nQuedo atento."

                    binding.floatingBtnMail.setOnClickListener {
                        val mail = "info@novaera.cl"
                        val intentMail = Intent(ACTION_SEND, Uri.parse(mail))
                        intentMail.type = "text/plain"
                        intentMail.putExtra(Intent.EXTRA_EMAIL, arrayOf(mail))
                        intentMail.putExtra(Intent.EXTRA_SUBJECT, asunto)
                        intentMail.putExtra(Intent.EXTRA_TEXT, message)
                        startActivity(Intent.createChooser(intentMail, "Send Mail"))
                    }
                }
            }
    }

    private fun initComponents() {
        viewModel.getCellPhoneDetailsViewModel(paramId.toString().toLong())
        viewModel.cellPhoneDetailsLiveData(paramId.toString().toLong())
            .observe(viewLifecycleOwner) {
                if (it != null) {
                    binding.imageDetail.load(it.image){
                        placeholder(R.drawable.loading)
                        error(R.drawable.image_not_available)
                    }
                    binding.tvDetailName.text = it.name
                    binding.tvDetailPrice.text = "AHORA $ ${it.price}"
                    binding.tvDetailDescription.text = "DESCRIPCIÓN \n ${it.description}"
                    binding.tvDetailLastPrice.text = "ANTES $ ${it.lastPrice}"
                    if (!it.credit) {
                        binding.tvDetailCredit.text = "Sólo efectivo"
                    } else {
                        binding.tvDetailCredit.text = "Acepta Crédito"
                    }
                }
            }
    }
}
