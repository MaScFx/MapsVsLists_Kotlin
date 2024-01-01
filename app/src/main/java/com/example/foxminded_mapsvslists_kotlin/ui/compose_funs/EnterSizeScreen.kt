package com.example.foxminded_mapsvslists_kotlin.ui.compose_funs

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foxminded_mapsvslists_kotlin.R
import com.example.foxminded_mapsvslists_kotlin.model.constants.isNumeric

@Composable
fun EnterSizeScreen(
    title: String,
    textFieldValue: String,
    onClickButton: (String) -> Unit,
    numberInTextFieldField: Int
) {

    val context = LocalContext.current
    val enterParam = remember {
        mutableStateOf(numberInTextFieldField.toString())
    }

    Column {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )

        TextField(value = enterParam.value,
            label = { Text(text = textFieldValue) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            onValueChange = {
                enterParam.value = it.filter { c -> c.isDigit() }
            })

        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = {
                    if (enterParam.value.isNumeric()) {
                        onClickButton(enterParam.value)
                    } else {
                        Toast.makeText(
                            context,
                            context.resources.getString(R.string.only_numbers),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }, modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = stringResource(R.string.calculate))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EnterSizeScreenPreview() {
    EnterSizeScreen(
        title = stringResource(id = R.string.collection_title),
        onClickButton = {},
        textFieldValue = stringResource(id = R.string.tf_enter_value),
        numberInTextFieldField = 1_500_000
    )
}

