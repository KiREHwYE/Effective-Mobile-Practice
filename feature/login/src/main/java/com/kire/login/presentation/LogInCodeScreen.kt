package com.kire.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.navigation.NavController
import com.kire.login.presentation.constant.LogInStrings.EMAIL_HINT
import com.kire.login.presentation.constant.LogInStrings.SENT_CODE_TO
import com.kire.login.presentation.constant.LogInStrings.SUBMIT
import com.kire.login.presentation.constant.LogInStrings.WRITE_CODE_SUGGESTION
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
fun LogInCodeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    navigateToMainScreen: () -> Unit = {}
) {

    /** Флаг того, введен ли код или нет */
    var isCodeCompleted by remember { mutableStateOf(false) }

    /** Цвет текста кнопки Продолжить */
    val continueTextColor by remember {
        derivedStateOf {
            if (!isCodeCompleted) extendedColor.grey4 else extendedColor.white
        }
    }
    /** Цвет фона кнопки Продолжить */
    val continueBackgroundColor by remember {
        derivedStateOf {
            if (!isCodeCompleted) extendedColor.darkBlue else extendedColor.blue
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
                isCodeCompleted = it
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .then(
                        // Делаем кнопку некликабельной, если код не введен
                        if (!isCodeCompleted)
                            Modifier
                        else Modifier
                            .bounceClick {
                                navigateToMainScreen()
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

