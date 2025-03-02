package com.kire.jobs.presentation.screen.vacancy_page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kire.jobs.presentation.viewmodel.JobsViewModel
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType

/**
 * Страница вакансии
 *
 * @param navController для навигации
 * @param jobsViewModel
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun VacancyPage(
    navController: NavController,
    jobsViewModel: JobsViewModel,
    vacancyId: String? = null
) {

    val vacancy = jobsViewModel.getVacancyById(vacancyId)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_16)
    ) {
        VacancyTopblock()
        VacancyTitleSection(vacancy)
        VacancyStats(vacancy)
        VacancyCompanySection(vacancy)

        Text(
            text = vacancy.description ?: "",
            style = extendedType.text1,
            color = extendedColor.white
        )

        VacancyResponsibilities(vacancy)
        VacancyQuestions(vacancy)
        VacancyApplyButton()
    }
}








