package com.kire.jobs.presentation.screen.vacancy_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.kire.jobs.presentation.constant.JobsStrings.ASK_QUESTIONS
import com.kire.jobs.presentation.constant.JobsStrings.HE_GETS_IT
import com.kire.jobs.presentation.model.vacancy.Vacancy
import com.kire.ui.Dimens.HORIZONTAL_PAD_12
import com.kire.ui.Dimens.ROUNDED_CORNERS_8
import com.kire.ui.Dimens.VERTICAL_PAD_8
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType

/**
 * Блок с вопросами, которые можно задать работодателю
 *
 * @param vacancy вакансия
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun VacancyQuestions(vacancy: Vacancy) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_8)
    ) {
        Text(
            text = ASK_QUESTIONS,
            style = extendedType.title4,
            color = extendedColor.white
        )
        Text(
            text = HE_GETS_IT,
            style = extendedType.title4,
            color = extendedColor.grey3
        )

        vacancy.questions.forEach { question ->
            QuestionTile(question)
        }
    }
}

/**
 * Плитка с вопросом
 *
 * @param question текст вопроса
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun QuestionTile(question: String) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(ROUNDED_CORNERS_8))
            .background(extendedColor.grey2)
            .padding(horizontal = HORIZONTAL_PAD_12, vertical = VERTICAL_PAD_8)
    ) {
        Text(
            text = question,
            style = extendedType.title4,
            color = extendedColor.white
        )
    }
}