package com.kire.jobs.presentation.screen.vacancy_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.kire.jobs.presentation.model.vacancy.Vacancy
import com.kire.ui.Dimens.HORIZONTAL_PAD_8
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.ui_component.Tile
import com.kire.vacancies.R

/**
 * Блок с информацией о компании
 *
 * @param vacancy вакансия
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun VacancyCompanySection(
    vacancy: Vacancy
) {

    Tile {

        // Название и значок аккредитации
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_8)
        ) {
            Text(
                text = vacancy.company ?: "Компания не указана",
                style = extendedType.title3,
                color = extendedColor.white
            )

            Icon(
                painter = painterResource(R.drawable.accreditation),
                contentDescription = "Accreditation",
                tint = extendedColor.grey3
            )
        }

        // Карта
        Image(
            painter = painterResource(R.drawable.map),
            contentDescription = "Map",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
        )

        // Адрес
        Text(
            text = "${vacancy.address.town}, ${vacancy.address.street}, ${vacancy.address.house}",
            style = extendedType.text1,
            color = extendedColor.white
        )
    }
}