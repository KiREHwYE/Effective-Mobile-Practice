package com.kire.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import com.kire.login.constant.LoginStrings.CONTINUE
import com.kire.login.constant.LoginStrings.EMPLOYEES_SEARCH
import com.kire.login.constant.LoginStrings.I_SEARCH_FOR_EMPLOYEES
import com.kire.login.constant.LoginStrings.JOB_SEARCH
import com.kire.login.constant.LoginStrings.LOGIN_VIA_PASSWORD
import com.kire.login.constant.LoginStrings.POSTING_VACANCIES
import com.kire.ui.Dimens.HORIZONTAL_PAD_24
import com.kire.ui.Dimens.HORIZONTAL_PAD_44
import com.kire.ui.Dimens.ROUNDED_CORNERS_50_PERCENT
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.Dimens.VERTICAL_PAD_11
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_7
import com.kire.ui.Dimens.VERTICAL_PAD_8
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.ui_component.Tile
import com.kire.ui.util.bounceClick

/**
 * Экран логина с вводом данных для входа
 *
 * @param modifier модификатор
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {

    /** Просто затычка */
    val state = rememberTextFieldState("")

    /** Цвет текста кнопки Продолжить */
    val continueTextColor by remember {
        derivedStateOf {
            if (state.text.isNotEmpty()) extendedColor.grey2 else extendedColor.white
        }
    }
    /** Цвет фона кнопки Продолжить */
    val continueBackgroundColor by remember {
        derivedStateOf {
            if (state.text.isNotEmpty()) extendedColor.darkBlue else extendedColor.blue
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_16),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Плитка поиска работы
        Tile {
            Text(
                text = JOB_SEARCH,
                style = extendedType.title3
            )

            // Просто затычка
            BasicTextField(
                state = state,
                decorator = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .background(extendedColor.grey2)
                    ) {
                        innerTextField()
                    }
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_24)
            ) {
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
                        .drawBehind { drawRect(color = continueBackgroundColor) }
                        .bounceClick {
                            // TODO
                        }
                        .padding(
                            vertical = VERTICAL_PAD_11,
                            horizontal = HORIZONTAL_PAD_44
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    BasicText(
                        text = CONTINUE,
                        color = { continueTextColor },
                        style = extendedType.buttonText2,
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentHeight()
                        .bounceClick {
                            // TODO
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = LOGIN_VIA_PASSWORD,
                        color = extendedColor.blue,
                        style = extendedType.buttonText2,
                    )
                }
            }
        }

        // Плитка поиска сотрудников
        Tile {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_8),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = EMPLOYEES_SEARCH,
                    style = extendedType.title3,
                    color = extendedColor.white
                )

                Text(
                    text = POSTING_VACANCIES,
                    style = extendedType.buttonText2,
                    color = extendedColor.white
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(ROUNDED_CORNERS_50_PERCENT))
                    .background(extendedColor.green)
                    .bounceClick {
                        // Некоторое действие, которое по заданию не дано
                    }
                    .padding(vertical = VERTICAL_PAD_7),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = I_SEARCH_FOR_EMPLOYEES,
                    style = extendedType.buttonText2,
                    color = extendedColor.white
                )
            }
        }
    }
}