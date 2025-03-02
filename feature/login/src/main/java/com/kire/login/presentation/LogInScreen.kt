package com.kire.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.navigation.NavController
import com.kire.login.presentation.constant.LogInDimens.TEXTFIELD_HEIGHT
import com.kire.login.presentation.constant.LogInStrings.CONTINUE
import com.kire.login.presentation.constant.LogInStrings.EMAIL_HINT
import com.kire.login.presentation.constant.LogInStrings.EMPLOYEES_SEARCH
import com.kire.login.presentation.constant.LogInStrings.I_SEARCH_FOR_EMPLOYEES
import com.kire.login.presentation.constant.LogInStrings.JOB_SEARCH
import com.kire.login.presentation.constant.LogInStrings.LOGIN_VIA_PASSWORD
import com.kire.login.presentation.constant.LogInStrings.POSTING_VACANCIES
import com.kire.login.navigation.LogInRoutes
import com.kire.ui.Dimens.HORIZONTAL_PAD_24
import com.kire.ui.Dimens.HORIZONTAL_PAD_44
import com.kire.ui.Dimens.HORIZONTAL_PAD_8
import com.kire.ui.Dimens.ROUNDED_CORNERS_50_PERCENT
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.Dimens.VERTICAL_PAD_11
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_7
import com.kire.ui.Dimens.VERTICAL_PAD_8
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.ui_component.GreenButton
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
fun LogInScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    // Заголовок экрана
    Topbar()

    /** Состояние поля ввода, в которое пользователь вводит почту*/
    val state = rememberTextFieldState("")
    val interactionSource = remember { MutableInteractionSource() }
    /** Чтобы убирать hint, если пользователь тапнул по полю ввода*/
    val isFocused by interactionSource.collectIsFocusedAsState()

    /** Цвет текста кнопки Продолжить */
    val continueTextColor by remember {
        derivedStateOf {
            if (state.text.isBlank()) extendedColor.grey4 else extendedColor.white
        }
    }
    /** Цвет фона кнопки Продолжить */
    val continueBackgroundColor by remember {
        derivedStateOf {
            if (state.text.isBlank()) extendedColor.darkBlue else extendedColor.blue
        }
    }

    Box(
        modifier = modifier
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
            // Плитка поиска работы
            Tile {
                Text(
                    text = JOB_SEARCH,
                    style = extendedType.title3,
                    color = extendedColor.white
                )

                BasicTextField(
                    state = state,
                    interactionSource = interactionSource,
                    decorator = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(TEXTFIELD_HEIGHT)
                                .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
                                .background(extendedColor.grey2)
                                .padding(horizontal = HORIZONTAL_PAD_8),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (state.text.isNotBlank() || isFocused)
                                innerTextField()
                            else
                                Text(
                                    text = EMAIL_HINT,
                                    style = extendedType.buttonText2,
                                    color = extendedColor.grey4
                                )
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
                            .then(
                                // Делаем кнопку некликабельной, если BasicTextField пустой
                                if (state.text.isBlank())
                                    Modifier
                                else Modifier
                                    .bounceClick {
                                        navController.navigate(LogInRoutes.LogInCode.route)
                                    }
                            )
                            .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
                            .drawBehind { drawRect(color = continueBackgroundColor) }
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
                                // По макету и тех.заданию не дано
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
                    horizontalAlignment = Alignment.Start
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

                GreenButton(
                    text = I_SEARCH_FOR_EMPLOYEES,
                    action = {
                        // Некоторое действие, которое по заданию не дано
                    }
                )
            }
        }
    }
}