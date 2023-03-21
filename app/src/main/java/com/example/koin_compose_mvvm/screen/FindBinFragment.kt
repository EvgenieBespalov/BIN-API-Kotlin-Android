package com.example.koin_compose_mvvm.screen

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.fragment.app.Fragment
import com.example.koin_compose_mvvm.R
import com.example.koin_compose_mvvm.presentation.FindBinUiState
import com.example.koin_compose_mvvm.presentation.FindBinViewModel

class FindBinFragment : Fragment(R.layout.fragment_find_bin)  {
    private val progressBar get() = requireView().findViewById<ProgressBar>(R.id.progressBar)
    private val errorText get() = requireView().findViewById<TextView>(R.id.errorText)
    private val filterContent get() = requireView().findViewById<LinearLayout>(R.id.filterFindBin)

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

        //setListeners()
    }

    /*private fun setListeners(){
        binCards.setOnClickListener {
            val selectRadioButton = requireView().findViewById<RadioButton>(genderRadioButtons.checkedRadioButtonId)
            val selectGender = when(selectRadioButton.text){
                "Female" -> "female"
                "Male" -> "male"
                else -> null
            }

            viewModel.setNeedToLoadNewUsers()

            val seed = when(seedEditText.text.toString().length){
                0 -> null
                else -> seedEditText.text.toString()
            }
            //mainActivity.searchUsers(numberOfUsersSeekBar.progress, selectGender, seed)
        }
    }*/

    private fun handleState(state: FindBinUiState) {
        when (state) {
            FindBinUiState.Initial    -> showContent()
        }
    }

    private fun showContent() {
        progressBar.isVisible = false
        errorText.isVisible = false
    }
}