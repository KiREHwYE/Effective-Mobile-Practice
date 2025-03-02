package com.kire.jobs.presentation.screen.main.topblock

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.kire.jobs.presentation.constant.JobsDimens.FILTER_SIZE
import com.kire.jobs.presentation.constant.JobsStrings.SEARCH_HINT
import com.kire.ui.Dimens.HORIZONTAL_PAD_8
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.theme.ExtendedTheme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.vacancies.R

/**
 * Бутафорский поиск
 *
 * @param modifier модификатор
 * @param onSearch действие при изменении поисковой строки - бутафория
 * @param onSearch действие при параметра фильтрации - бутафория
 * @param icon иконка
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun Search(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {},
    onFilter: (String) -> Unit = {},
    icon: @Composable () -> Unit
){
    /** Состояние поля ввода, в которое пользователь вводит почту*/
    val state = rememberTextFieldState("")
    val interactionSource = remember { MutableInteractionSource() }
    /** Чтобы убирать hint, если пользователь тапнул по полю ввода*/
    val isFocused by interactionSource.collectIsFocusedAsState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_8)
    ) {

        // Кнопка поиск
        BasicTextField(
            state = state,
            interactionSource = interactionSource,
            decorator = { innerTextField ->
                Row (
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
                        .background(extendedColor.grey2)
                        .padding(horizontal = HORIZONTAL_PAD_8),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    icon()

                    if (state.text.isNotBlank() || isFocused)
                        innerTextField()
                    else
                        Text(
                            text = SEARCH_HINT,
                            style = extendedType.buttonText2,
                            color = com.kire.ui.theme.extendedColor.grey4,
                            modifier = Modifier.padding(start = HORIZONTAL_PAD_8)
                        )
                }
            },
            modifier = Modifier
                .weight(1f)
        )

        // Кнопка фильтра
        Box(
            modifier = Modifier
                .size(FILTER_SIZE)
                .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
                .background(extendedColor.grey2),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.filter),
                contentDescription = "Search filter button",
                tint = extendedColor.white
            )
        }
    }
}