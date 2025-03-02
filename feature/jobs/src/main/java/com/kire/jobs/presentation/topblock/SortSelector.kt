package com.kire.jobs.presentation.topblock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.kire.jobs.presentation.constant.JobsStrings.BY_RELEVANCY
import com.kire.ui.Dimens.HORIZONTAL_PAD_6
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.util.bounceClick
import com.kire.vacancies.R

/**
 *  При тапе на данный компонент
 *  открывается панель с опциями для сортировки.
 *
 *  ---Бутафория---
 *
 *  @param modifier модификатор
 *  @param onClick действие при клике на весь компонент
 *
 *  @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun SortSelector(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .bounceClick { onClick() },
        horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_6),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = BY_RELEVANCY,
            color = extendedColor.blue,
            style = extendedType.text1
        )

        Column {

            Icon(
                painter = painterResource(R.drawable.arrow_up),
                contentDescription = "Arrow Up",
                tint = extendedColor.blue
            )
            Icon(
                painter = painterResource(R.drawable.arrow_down),
                contentDescription = "Arrow Down",
                tint = extendedColor.blue
            )
        }
    }
}