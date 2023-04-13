package com.example.koin_compose_mvvm.screen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.view.isVisible
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.fragment.app.Fragment
import com.example.koin_compose_mvvm.R
import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.presentation.FindBinUiState
import com.example.koin_compose_mvvm.presentation.FindBinViewModel
import com.example.koin_compose_mvvm.screen.compose.FindBinScreen
import com.google.accompanist.themeadapter.material.MdcTheme

class FindBinFragment : Fragment(R.layout.fragment_find_bin)  {
   /* override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MdcTheme {
                    FindBinScreen()
                }
            }
        }*/


    private val progressBar get() = requireView().findViewById<ProgressBar>(R.id.binCardProgressBar)
    private val errorText get() = requireView().findViewById<TextView>(R.id.binCardErrorText)

    private val findBinFragmentContent get() = requireView().findViewById<LinearLayout>(R.id.findBinFragmentContent)

    private val bankNameContent get() = requireView().findViewById<LinearLayout>(R.id.bankNameContent)
    private val bankCityContent get() = requireView().findViewById<LinearLayout>(R.id.bankCityContent)
    private val bankSiteContent get() = requireView().findViewById<LinearLayout>(R.id.bankSiteContent)
    private val bankPhoneContent get() = requireView().findViewById<LinearLayout>(R.id.bankPhoneContent)
    private val schemeNetworkContent get() = requireView().findViewById<LinearLayout>(R.id.schemeNetworkContent)
    private val brandContent get() = requireView().findViewById<LinearLayout>(R.id.brandContent)
    private val cardLengthContent get() = requireView().findViewById<LinearLayout>(R.id.cardLengthContent)
    private val cardLuhnContent get() = requireView().findViewById<LinearLayout>(R.id.cardLuhnContent)
    private val typeContent get() = requireView().findViewById<LinearLayout>(R.id.typeContent)
    private val prepaidContent get() = requireView().findViewById<LinearLayout>(R.id.prepaidContent)
    private val countryNameContent get() = requireView().findViewById<LinearLayout>(R.id.countryNameContent)
    private val countryLatitudeContent get() = requireView().findViewById<LinearLayout>(R.id.countryLatitudeContent)

    private val viewModel: FindBinViewModel by viewModel()

    private val binCardEditText get() = requireView().findViewById<EditText>(R.id.binCardEditText)

    private val bankNameTextView get() = requireView().findViewById<TextView>(R.id.bankNameTextView)
    private val bankCityTextView get() = requireView().findViewById<TextView>(R.id.bankCityTextView)
    private val bankSiteTextView get() = requireView().findViewById<TextView>(R.id.bankSiteTextView)
    private val bankPhoneTextView get() = requireView().findViewById<TextView>(R.id.bankPhoneTextView)
    private val schemeNetworkTextView get() = requireView().findViewById<TextView>(R.id.schemeNetworkTextView)
    private val brandTextView get() = requireView().findViewById<TextView>(R.id.brandTextView)
    private val cardLengthTextView get() = requireView().findViewById<TextView>(R.id.cardLengthTextView)
    private val cardLuhnTextView get() = requireView().findViewById<TextView>(R.id.cardLuhnTextView)
    private val typeTextView  get() = requireView().findViewById<TextView>(R.id.typeTextView)
    private val prepaidTextView  get() = requireView().findViewById<TextView>(R.id.prepaidTextView)
    private val countryEmojiTextView get() = requireView().findViewById<TextView>(R.id.countryEmojiTextView)
    private val countryNameTextView get() = requireView().findViewById<TextView>(R.id.countryNameTextView)
    private val countryLatitudeTextView get() = requireView().findViewById<TextView>(R.id.countryLatitudeTextView)
    private val countryLongitudeTextView get() = requireView().findViewById<TextView>(R.id.countryLongitudeTextView)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, ::handleState)
        viewModel.initial()

        setListener()
    }

    private fun setListener(){
        binCardEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s != null && s.length == 8)
                    viewModel.getDataBin(s.toString())
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
        findBinFragmentContent.isVisible = false
    }

    private fun showError(message: String?) {
        errorText.isVisible = true
        progressBar.isVisible = false
        findBinFragmentContent.isVisible = false

        errorText.text = message ?: requireContext().getText(R.string.unknown_error)
    }

    private fun showContent(bin: MainData) {
        progressBar.isVisible = false
        errorText.isVisible = false
        findBinFragmentContent.isVisible = true

        when(bin.bank.name){
            null -> bankNameContent.isVisible = false
            else -> bankNameTextView.setText(bin.bank.name)
        }
        when(bin.bank.city){
            null -> bankCityContent.isVisible = false
            else -> bankCityTextView.setText(bin.bank.city)
        }
        when(bin.bank.url){
            null -> bankSiteContent.isVisible = false
            else -> bankSiteTextView.setText(bin.bank.url)
        }
        when(bin.bank.phone){
            null -> bankPhoneContent.isVisible = false
            else -> bankPhoneTextView.setText(bin.bank.phone)
        }
        when(bin.scheme){
            null -> schemeNetworkContent.isVisible = false
            else ->  schemeNetworkTextView.setText(bin.scheme)
        }
        when(bin.brand){
            null -> brandContent.isVisible = false
            else -> brandTextView.setText(bin.brand)
        }
        when(bin.number.luhn){
            null -> cardLuhnContent.isVisible = false
            else -> cardLuhnTextView.setText(bin.number.luhn)
        }
        when(bin.type){
            null -> typeContent.isVisible = false
            else -> typeTextView.setText(bin.type)
        }
        when(bin.prepaid){
            null -> prepaidContent.isVisible = false
            else -> prepaidTextView.setText(bin.prepaid)
        }
        when(bin.country.emoji){
            null -> countryEmojiTextView.isVisible = false
            else -> countryEmojiTextView.setText(bin.country.emoji)
        }
        when(bin.country.name){
            null -> countryNameContent.isVisible = false
            else -> {
                countryNameTextView.setText(bin.country.name)
                countryEmojiTextView.setText(bin.country.emoji)}
        }
        when(bin.country.latitude){
            null -> countryLatitudeTextView.isVisible = false
            else -> countryLatitudeTextView.setText(bin.country.latitude)
        }
     /*   when(bin.country.longitude){
            null -> countryLongitudeTextView.isVisible = false
            else -> countryLongitudeTextView.setText(bin.country.longitude)
        }*/
    }
}