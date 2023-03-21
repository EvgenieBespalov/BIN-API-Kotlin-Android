package com.example.koin_compose_mvvm.screen

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.koin_compose_mvvm.R
import com.example.koin_compose_mvvm.presentation.BinHistoryViewModel
import com.example.koin_compose_mvvm.presentation.FindBinUiState
import com.example.koin_compose_mvvm.presentation.FindBinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BinHistoryFragment : Fragment(R.layout.fragment_bin_history)  {
    private val progressBar get() = requireView().findViewById<ProgressBar>(R.id.progressBar)
    private val errorText get() = requireView().findViewById<TextView>(R.id.errorText)
    private val filterContent get() = requireView().findViewById<LinearLayout>(R.id.filterFindBin)

    private val viewModel: BinHistoryViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, ::handleState)
        viewModel.initial()

        //setListeners()
    }

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