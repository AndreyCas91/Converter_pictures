package com.gb.converter_pictures.ui.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gb.converter_pictures.App
import com.gb.converter_pictures.databinding.FragmentConverterBinding
import com.gb.converter_pictures.ui.base.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ConverterFragment: MvpAppCompatFragment(), ConverterView, BackButtonListener {

    private val presenter by moxyPresenter { ConverterPresenter(App.instance.router, this) }

    private var _binding: FragmentConverterBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConverterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConverter.setOnClickListener{
            presenter.onButtonClicked()

            visibilityItem()
        }

    }

    private fun visibilityItem() {
        binding.btnCancel.visibility = View.VISIBLE
        binding.textView.visibility = View.VISIBLE
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

}