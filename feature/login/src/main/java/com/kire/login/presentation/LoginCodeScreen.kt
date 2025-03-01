package com.kire.login.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.kire.login.constant.LoginStrings.EMAIL_HINT
import com.kire.login.constant.LoginStrings.SENT_CODE_TO
import com.kire.login.constant.LoginStrings.SUBMIT
import com.kire.login.constant.LoginStrings.WRITE_CODE_SUGGESTION
import com.kire.login.navigation.LoginRoutes
import com.kire.ui.Dimens.CODE_INPUT_FIELD_SIZE
import com.kire.ui.Dimens.HORIZONTAL_PAD_8
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.Dimens.VERTICAL_PAD_14
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.util.bounceClick


/**
 * Экран ввода кода, отправленного на почту
 *
 * @param modifier модификатор
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun LoginCodeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    var isActive by remember { mutableStateOf(false) }

    /** Цвет текста кнопки Продолжить */
    val continueTextColor by remember {
        derivedStateOf {
            if (!isActive) extendedColor.grey4 else extendedColor.white
        }
    }
    /** Цвет фона кнопки Продолжить */
    val continueBackgroundColor by remember {
        derivedStateOf {
            if (!isActive) extendedColor.darkBlue else extendedColor.blue
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_16),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = SENT_CODE_TO + EMAIL_HINT,
                style = extendedType.title2,
                color = extendedColor.white
            )

            Text(
                text = WRITE_CODE_SUGGESTION,
                style = extendedType.title3,
                color = extendedColor.white
            )

            CodeInputField {
                isActive = it
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .then(
                        // Делаем кнопку некликабельной, если код не введен
                        if (!isActive)
                            Modifier
                        else Modifier
                            .bounceClick {
                                // TODO
                            }
                    )
                    .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
                    .drawBehind { drawRect(color = continueBackgroundColor) }
                    .padding(vertical = VERTICAL_PAD_14),
                contentAlignment = Alignment.Center
            ) {
                BasicText(
                    text = SUBMIT,
                    style = extendedType.buttonText1,
                    color = { continueTextColor }
                )
            }
        }
    }
}

