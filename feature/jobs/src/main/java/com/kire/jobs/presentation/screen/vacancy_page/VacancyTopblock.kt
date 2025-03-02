package com.kire.jobs.presentation.screen.vacancy_page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.kire.ui.Dimens.HORIZONTAL_PAD_16
import com.kire.ui.theme.extendedColor
import com.kire.ui.util.bounceClick
import com.kire.vacancies.R

/**
 * Топблок экрана вакансии
 *
 * @param modifier модификатор
 * @param isFavorite в избранном ли вакансия или нет
 * @param onBackClick действие при клике на стрелочку назад
 * @param onVisibilityClick действие при клике на глаз
 * @param onShareClick действие при клике на кнопку "поделиться"
 * @param onHeartClick действие при клике на сердечко
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun VacancyTopblock(
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    onBackClick: () -> Unit = {},
    onVisibilityClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onHeartClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(R.drawable.arrow_back),
            contentDescription = "Back",
            tint = extendedColor.white,
            modifier = Modifier
                .bounceClick {
                    onBackClick()
                }
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_16 )
        ) {
            Icon(
                painter = painterResource(R.drawable.eye),
                contentDescription = "Visibility",
                tint = extendedColor.white,
                modifier = Modifier
                    .bounceClick {
                        onVisibilityClick()
                    }
            )
            Icon(
                painter = painterResource(R.drawable.share),
                contentDescription = "Share",
                tint = extendedColor.white,
                modifier = Modifier
                    .bounceClick {
                        onShareClick()
                    }
            )
            Icon(
                painter = painterResource(
                    if (isFavorite == true)
                        R.drawable.filled_heart
                    else R.drawable.unfilled_heart
                ),
                contentDescription = "Heart",
                tint = if (isFavorite == true)
                    extendedColor.blue
                else extendedColor.white,
                modifier = Modifier
                    .bounceClick {
                        onHeartClick()
                    }
            )
        }
    }
}