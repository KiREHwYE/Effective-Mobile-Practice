package com.kire.jobs.presentation.screen.vacancy_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.kire.jobs.presentation.constant.JobsDimens.STATS_BADGE_HEIGHT
import com.kire.jobs.presentation.constant.JobsDimens.VACANCY_PAGE_SMALL_ICON_SIZE
import com.kire.jobs.presentation.model.vacancy.Vacancy
import com.kire.ui.Dimens.HORIZONTAL_PAD_21
import com.kire.ui.Dimens.HORIZONTAL_PAD_8
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.Dimens.VERTICAL_PAD_8
import com.kire.ui.theme.ExtendedTheme.extendedColor
import com.kire.ui.theme.ExtendedTheme.extendedType
import com.kire.util.getPeopleDeclension
import com.kire.vacancies.R

/**
 * Блок с информацией о том, сколько человек
 * уже откликнулось и сколько просматривают вакансию
 *
 * @param vacancy вакансия
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun VacancyStats(vacancy: Vacancy) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_8)
    ) {
        vacancy.appliedNumber?.let {
            StatBadge(
                modifier = Modifier.weight(1f),
                text = "$it ${it.getPeopleDeclension()} уже откликнулись",
                painter = painterResource(R.drawable.small_person)
            )
        }
        vacancy.lookingNumber?.let {
            StatBadge(
                modifier = Modifier.weight(1f),
                text = "$it ${it.getPeopleDeclension()} сейчас смотрят",
                painter = painterResource(R.drawable.small_eye)
            )
        }
    }
}

/**
 * Зеленая плитка с иконкой для некоторой информации
 *
 * @param modifier модификатор
 * @param text текст
 * @param painter painter с иконкой для отображения
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun StatBadge(
    modifier: Modifier = Modifier,
    text: String = "",
    painter: Painter
) {
    Row(
        modifier = modifier
            .height(STATS_BADGE_HEIGHT)
            .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
            .background(extendedColor.darkGreen)
            .padding(horizontal = HORIZONTAL_PAD_8, vertical = VERTICAL_PAD_8),
        horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_21)
    ) {
        Text(
            text = text,
            style = extendedType.text1,
            color = extendedColor.white,
            maxLines = 2
        )

        Box(
            modifier = Modifier
                .height(STATS_BADGE_HEIGHT)
                .wrapContentWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Box(
                modifier = Modifier
                    .size(VACANCY_PAGE_SMALL_ICON_SIZE)
                    .clip(CircleShape)
                    .background(extendedColor.green),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painter,
                    contentDescription = null,
                    tint = extendedColor.white
                )
            }
        }
    }
}