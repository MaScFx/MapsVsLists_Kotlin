package com.example.foxminded_mapsvslists_kotlin.ui

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foxminded_mapsvslists_kotlin.R
import com.example.foxminded_mapsvslists_kotlin.ui.theme.Black
import com.example.foxminded_mapsvslists_kotlin.ui.theme.Orange
import com.example.foxminded_mapsvslists_kotlin.ui.theme.Red
import com.example.foxminded_mapsvslists_kotlin.utils.isNumeric

@Composable
fun EnterSizeScreen(
    title: String,
    textFieldValue: String,
    onClickButton: (String) -> Unit,
    numberInTextField: Int,
    onChangeInputCount: (Int) -> Unit
) {
    val isError = remember { mutableStateOf(false) }

    val context = LocalContext.current
    val enterParam = remember {
        if (numberInTextField < 1) {
            mutableStateOf("")
        } else {
            mutableStateOf(numberInTextField.toString())
        }
    }

    Column {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 35.dp)
        )

        TextField(value = enterParam.value,
            singleLine = true,
            label = { Text(text = textFieldValue) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 21.dp, start = 30.dp, end = 30.dp, bottom = 100.dp),
//                .height(64.dp),
            onValueChange = {
                enterParam.value = it
                if (it.isNumeric() && it.toIntOrNull() != null) {
                    onChangeInputCount(it.toInt())
                    isError.value = false
                } else {
                    isError.value = true
                }
            },
            isError = isError.value,
            supportingText = {
                if (isError.value) {
                    Box(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxSize()

                    ) {
                        Canvas(modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                            .align(Alignment.CenterEnd)
                            .absoluteOffset(x = (-70).dp), onDraw = {
                            rotate(degrees = 45F) {
                                drawRoundRect(size = size, color = Red)
                            }
                        })

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp, start = 31.dp, end = 26.dp)
                                .height(36.dp)
                                .clip(RoundedCornerShape(9.dp))
                                .background(Red)

                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .weight(0.85f)
//                                        .fillMaxWidth()
                                        .padding(start = 10.dp, top = 8.dp),
                                    text = stringResource(R.string.error_you_need_enter_elements_count),
                                    color = Black,
                                    fontSize = 10.sp,
//                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.attention),
                                    alignment = Alignment.CenterEnd,
                                    contentDescription = stringResource(R.string.attention),
                                    modifier = Modifier
                                        .padding(end = 5.dp)
                                        .weight(0.15f)
                                        .height(35.dp)
                                        .width(35.dp)
                                )
                            }
                        }
                    }
                }
            })

        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                colors = ButtonColors(
                    containerColor = Orange,
                    contentColor = Color.White,
                    disabledContainerColor = Orange,
                    disabledContentColor = Color.White
                ),
                shape = RoundedCornerShape(9.dp),
                onClick = {
                    val enterNum = enterParam.value.toIntOrNull()
                    if ( enterNum != null && enterNum in 3..Int.MAX_VALUE  ) {
                        onClickButton(enterParam.value)
                    } else {
                        Toast.makeText(
                            context,
                            context.resources.getString(R.string.only_correct_numbers),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = 39.dp, start = 30.dp, end = 30.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .height(62.dp)
                    .background(Orange)
            ) {
                Text(
                    text = stringResource(R.string.calculate),
                    fontSize = 14.sp,
//                    fontFamily = FontFamily(Font(R.font.poppins_medium))
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EnterSizeScreenPreview() {
    EnterSizeScreen(title = stringResource(id = R.string.collection_title),
        onClickButton = {},
        textFieldValue = stringResource(id = R.string.tf_enter_value),
        numberInTextField = -1,
        onChangeInputCount = {})
}

