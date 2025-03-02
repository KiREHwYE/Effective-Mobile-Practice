package com.kire.jobs.presentation.topblock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.util.getVacancyDeclension

/**
 * Блок с информацией о числе вакансий и сортировкой
 *
 * @param modifier модификатор
 * @param vacanciesNumber число вакансий
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun Sorting(
    modifier: Modifier = Modifier,
    vacanciesNumber: Int = 0
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$vacanciesNumber ${vacanciesNumber.getVacancyDeclension()}",
            style = extendedType.text1,
            color = extendedColor.white
        )

        SortSelector()
    }
}
