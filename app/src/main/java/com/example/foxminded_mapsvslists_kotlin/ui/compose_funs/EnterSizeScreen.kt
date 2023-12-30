package com.example.foxminded_mapsvslists_kotlin.ui.compose_funs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foxminded_mapsvslists_kotlin.vm.CollectionViewModel

@Composable
fun EnterSizeScreen(
    title: String = "title",
    textFieldValue: String = "enter value",
    onClickButton : (Int)->Unit
) {

    val enterParam = remember {
        mutableStateOf("0")
    }
    Column {
        Text(
            text = title, fontSize = 20.sp, modifier = Modifier
                .padding(4.dp)
        )
        TextField(
            value = enterParam.value,
            label = { Text(text = textFieldValue) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(4.dp),
            onValueChange = {
                enterParam.value = it
            }
        )
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = { onClickButton(enterParam.value.toInt()) },
                modifier = Modifier.align(Alignment.Center),
            ) {
                Text(text = "CALCULATE")
            }
        }
    }

}

