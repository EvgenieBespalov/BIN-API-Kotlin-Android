package com.example.koin_compose_mvvm.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.koin_compose_mvvm.R
import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.presentation.FindBinUiState
import com.example.koin_compose_mvvm.presentation.FindBinViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.FileNotFoundException
import java.net.URL

class FindBinFragment : Fragment(R.layout.fragment_find_bin)  {
    private val progressBar get() = requireView().findViewById<ProgressBar>(R.id.progressBar)
    private val errorText get() = requireView().findViewById<TextView>(R.id.errorText)
    private val filterFindBinContent get() = requireView().findViewById<LinearLayout>(R.id.filterFindBin)

    private val viewModel: FindBinViewModel by viewModel()

    private val binCards get() = requireView().findViewById<EditText>(R.id.binCards)
    private val bankName get() = requireView().findViewById<TextView>(R.id.bankName)
    private val cityOfBank get() = requireView().findViewById<TextView>(R.id.cityOfBank)
    private val siteOfBank get() = requireView().findViewById<TextView>(R.id.siteOfBank)

    private val numberPhoneOfBank get() = requireView().findViewById<TextView>(R.id.numberPhoneOfBank)
    private val schemeOfBank get() = requireView().findViewById<TextView>(R.id.schemeOfBank)
    private val brand get() = requireView().findViewById<TextView>(R.id.brand)
    private val lengthBin get() = requireView().findViewById<TextView>(R.id.length)
    private val luhn get() = requireView().findViewById<TextView>(R.id.luhn)
    private val type  get() = requireView().findViewById<TextView>(R.id.type)
    private val prepaid  get() = requireView().findViewById<TextView>(R.id.prepaid)
    private val emoji get() = requireView().findViewById<TextView>(R.id.emoji)
    private val country get() = requireView().findViewById<TextView>(R.id.country)
    private val coordinates get() = requireView().findViewById<TextView>(R.id.coordinates)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, ::handleState)
        viewModel.initial()

        setListener()
    }

    private fun setListener(){
        binCards.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s != null && s.length == 8)
                    viewModel.getDataBin(s.toString().toInt())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun handleState(state: FindBinUiState) {
        when (state) {
            FindBinUiState.Initial    -> Unit
            FindBinUiState.Loading    -> showProgress()
            is FindBinUiState.Content -> showContent(state.bin)
            is FindBinUiState.Error   -> showError(state.message)
        }
    }

    private fun showProgress() {
        progressBar.isVisible = true
        errorText.isVisible = false
        filterFindBinContent.isVisible = false
    }

    private fun showError(message: String?) {
        errorText.isVisible = true
        progressBar.isVisible = false
        filterFindBinContent.isVisible = false

        errorText.text = message ?: requireContext().getText(R.string.unknown_error)
    }

    private fun showContent(bin: MainData) {
        progressBar.isVisible = false
        errorText.isVisible = false
        filterFindBinContent.isVisible = true

        bankName.setText(bin.bank.name)
        cityOfBank.setText(bin.bank.city)
        siteOfBank.setText(bin.bank.url)
        numberPhoneOfBank.setText(bin.bank.phone)
        schemeOfBank.setText(bin.scheme)
        brand.setText(bin.brand)
        lengthBin.setText(bin.number.length)
        luhn.setText(bin.number.luhn)
        type.setText(bin.type)
        prepaid.setText(bin.prepaid)
        emoji.setText(bin.country.emoji)
        country.setText(bin.country.name)
        coordinates.setText(bin.country.coordinates)
    }
}