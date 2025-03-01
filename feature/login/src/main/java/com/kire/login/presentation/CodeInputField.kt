package com.kire.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.kire.login.constant.LoginDimens.CODE_INPUT_FIELD_SIZE
import com.kire.ui.Dimens.HORIZONTAL_PAD_8
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType

/**
 * Поле ввода кода
 *
 * @param onCodeCompleted передает информацию о том введен ли уже код или нет
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun CodeInputField(
    onCodeCompleted: (Boolean) -> Unit
) {
    val codeLength = 4
    val code = remember { mutableStateListOf("", "", "", "") }
    val focusManager = LocalFocusManager.current
    val focusRequesters = List(codeLength) { FocusRequester() }

    val isCodeComplete by remember {
        derivedStateOf { code.all { it.isNotEmpty() } }
    }

    LaunchedEffect(isCodeComplete) {
        onCodeCompleted(isCodeComplete)
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_8),
        verticalAlignment = Alignment.CenterVertically
    ) {
        code.forEachIndexed { index, _ ->
            Box(
                modifier = Modifier
                    .size(CODE_INPUT_FIELD_SIZE)
                    .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
                    .background(color = extendedColor.grey2)
                    .clickable { focusRequesters[index].requestFocus() },
                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    value = code[index],
                    onValueChange = { newValue ->
                        if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                            code[index] = newValue
                            if (index < codeLength - 1) {
                                focusRequesters[index + 1].requestFocus()
                            }
                        }
                    },
                    textStyle = extendedType.title1
                        .copy(
                            fontSize = 24.sp,
                            lineHeight = 24.sp,
                            color = extendedColor.grey3,
                            textAlign = TextAlign.Center
                        ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = if (index == codeLength - 1) ImeAction.Done else ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            if (index < codeLength - 1) {
                                focusRequesters[index + 1].requestFocus()
                            }
                        },
                        onDone = { focusManager.clearFocus() }
                    ),
                    visualTransformation = { text ->
                        val transformedText = text.text.ifEmpty { "*" }
                        TransformedText(
                            text = AnnotatedString(transformedText),
                            offsetMapping = object : OffsetMapping {
                                override fun originalToTransformed(offset: Int) = 0
                                override fun transformedToOriginal(offset: Int) = 0
                            }
                        )
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .focusRequester(focusRequesters[index])
                        .onKeyEvent { keyEvent ->
                            if (keyEvent.type == KeyEventType.KeyUp && keyEvent.key == Key.Backspace) {
                                if (code[index].isNotEmpty()) {
                                    code[index] = ""
                                } else if (index > 0) {
                                    code[index - 1] = ""
                                    focusRequesters[index - 1].requestFocus()
                                }
                                true
                            } else {
                                false
                            }
                        },
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            innerTextField()
                        }
                    }
                )
            }
        }
    }
}