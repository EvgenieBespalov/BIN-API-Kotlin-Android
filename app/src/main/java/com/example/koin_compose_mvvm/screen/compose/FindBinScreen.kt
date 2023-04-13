package com.example.koin_compose_mvvm.screen.compose

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.koin_compose_mvvm.domain.entity.MainData
import com.example.koin_compose_mvvm.presentation.FindBinUiState
import com.example.koin_compose_mvvm.presentation.FindBinViewModel
import org.koin.androidx.compose.koinViewModel
import org.w3c.dom.Text


@Composable
fun FindBinScreen(
    viewModel: FindBinViewModel = koinViewModel(),
) {
    val state by viewModel.state.observeAsState(FindBinUiState.Initial)

    when(state){
        FindBinUiState.Initial    -> Unit
        FindBinUiState.Loading    -> FindBinLoadind()
        is FindBinUiState.Content -> FindBinContent()
        is FindBinUiState.Error   -> FindBinError(errorText = (state as FindBinUiState.Error).message.orEmpty())
    }
}

@Composable
fun FindBinLoadind(){
    CenteredColumn {
        CircularProgressIndicator()
    }
}

@Composable
fun RowData(content: @Composable RowScope.() -> Unit){
    Row(
        modifier = Modifier
            .padding(10.dp)
            .size(300.dp),
        content = content
    )
}

@Composable
fun TextData(content: @Composable Text.() -> Unit){
   /* Text(
        fontSize = 50.sp
    )*/
}



@Composable
fun FindBinContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        var text by rememberSaveable { mutableStateOf("BIN") }

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
        )
        RowData {
            Text( text = "text",
                fontSize = 50.sp
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text( text = "text",
            )
        }
        RowData {
            Text( text = "text",
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text( text = "text",
            )
        }
    }
}

@Composable
fun FindBinError(errorText: String){
    CenteredColumn {
        Text(text = errorText)
    }
}

@Composable
fun CenteredColumn(content: @Composable ColumnScope.() -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = content
    )
}

@Preview
@Composable
fun FindBinLoadindPreview(){
    FindBinContent()
}