package com.example.koin_compose_mvvm.screen

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.koin_compose_mvvm.R
import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.presentation.BinHistoryUiState
import com.example.koin_compose_mvvm.presentation.BinHistoryViewModel
import com.example.koin_compose_mvvm.presentation.FindBinUiState
import com.example.koin_compose_mvvm.presentation.FindBinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BinHistoryFragment : Fragment(R.layout.fragment_bin_history)  {
    private val progressBar get() = requireView().findViewById<ProgressBar>(R.id.progressBar)
    private val errorText get() = requireView().findViewById<TextView>(R.id.errorText)
    private val binHistoryContent get() = requireView().findViewById<LinearLayout>(R.id.binHistoryContent)


    private var binHistory: RecyclerView? = null

    private val viewModel: BinHistoryViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binHistory = view.findViewById(R.id.historyRecyclerView)
        binHistory?.adapter = BinHistoryAdapter(::handleLoanClick)

        viewModel.state.observe(viewLifecycleOwner, ::handleState)

        viewModel.loadData()
    }

    private fun handleLoanClick(mainData: MainData) {
        //mainActivity.openUserDetails(mainData.id)
    }

    private fun handleState(state: BinHistoryUiState) {
        when (state) {
            BinHistoryUiState.Initial    -> Unit
            BinHistoryUiState.Loading    -> showProgress()
            is BinHistoryUiState.Content -> showContent(state.mainData)
            is BinHistoryUiState.Error   -> showError(state.message)
        }
    }

    private fun showContent(listBin: List<MainData>) {
        progressBar.isVisible = false
        errorText.isVisible = false
        binHistoryContent.isVisible = true
        (binHistory?.adapter as? BinHistoryAdapter)?.mainData = listBin
    }

    private fun showProgress() {
        progressBar.isVisible = true
        errorText.isVisible = false
        binHistoryContent.isVisible = false
    }

    private fun showError(message: String?) {
        errorText.isVisible = true
        progressBar.isVisible = false
        binHistoryContent.isVisible = false

        errorText.text = message ?: requireContext().getText(R.string.unknown_error)
    }

    override fun onDestroy() {
        binHistory?.adapter = null
        binHistory = null
        super.onDestroy()
    }
}