package com.kire.jobs.presentation.screen.vacancy_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.theme.ExtendedTheme.extendedColor
import com.kire.ui.theme.ExtendedTheme.extendedType
import com.kire.ui.util.bounceClick
import com.kire.jobs.presentation.constant.JobsStrings.APPLY_FOR
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import com.kire.ui.Dimens.VERTICAL_PAD_14

/**
 * Кнопка отклика на вакансию
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun VacancyApplyButton(
    onClick: () -> Unit = {}
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
            .bounceClick {
                onClick()
            }
            .background(extendedColor.green)
            .padding(vertical = VERTICAL_PAD_14),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = APPLY_FOR,
            style = extendedType.buttonText1,
            color = extendedColor.white
        )
    }
}