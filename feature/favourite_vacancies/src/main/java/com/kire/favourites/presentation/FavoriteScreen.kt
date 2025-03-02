package com.kire.favourites.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kire.favourites.presentation.constant.FavoriteStrings.FAVORITE
import com.kire.favourites.presentation.model.FavoriteUiEvent
import com.kire.favourites.presentation.viewmodel.FavoriteViewModel
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_24
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.ui_component.Topbar
import com.kire.util.getVacancyDeclension

/**
 * Экран избранных вакансий
 *
 * @param favoriteViewModel для работы с избранными вакансиями
 * @param modifier модификатор
 * @param navigateToVacancyPageWithVacancyId для навигации на экран вакансии по id вакансии
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun FavoriteScreen(
    favoriteViewModel: FavoriteViewModel,
    modifier: Modifier = Modifier,
    navigateToVacancyPageWithVacancyId: (String?) -> Unit
) {
    /** Список избранных вакансий */
    val favoriteVacancies by favoriteViewModel.favoriteVacancies.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = VERTICAL_PAD_16),
        contentPadding = PaddingValues(bottom = VERTICAL_PAD_16),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_16)
    ) {

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_24),
                horizontalAlignment = Alignment.Start
            ) {
                // Топбар
                Topbar(text = FAVORITE)

                // Текст "Вакансии для вас"
                Text(
                    text = "${favoriteVacancies.size} ${favoriteVacancies.size.getVacancyDeclension()}",
                    style = extendedType.text1,
                    color = extendedColor.grey3
                )
            }
        }

        // Плитки вакансий
        items(favoriteVacancies) { favoriteVacancy ->
            VacancyTile(
                vacancy = favoriteVacancy,
                onTileClick = {
                    navigateToVacancyPageWithVacancyId(favoriteVacancy.id)
                },
                onHeartClick = {
                    favoriteVacancy.id?.let { id ->
                        favoriteViewModel.OnEvent(
                            FavoriteUiEvent.onHeartClick(id, !(favoriteVacancy.isFavorite ?: false))
                        )
                    }
                }
            )
        }
    }
}