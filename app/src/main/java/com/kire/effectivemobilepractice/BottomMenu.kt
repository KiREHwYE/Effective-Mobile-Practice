package com.kire.effectivemobilepractice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kire.jobs.navigation.JobsRoutes
import com.kire.ui.Dimens.HORIZONTAL_PAD_14
import com.kire.ui.Dimens.VERTICAL_PAD_3
import com.kire.ui.Dimens.VERTICAL_PAD_6
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType

/**
 * Меню навигации по приложению
 *
 * @param navController для навигации
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun BottomMenu(
    currentRoute: String?,
    navController: NavController,
    modifier: Modifier = Modifier,
    favoriteCount: Int = 0
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding())
            .padding(
                vertical = VERTICAL_PAD_6,
                horizontal = HORIZONTAL_PAD_14
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MenuDestinations.entries.forEach { destination ->
            // Вкладка меню
            BottomTab(
                isSelected = currentRoute == destination.route,
                destination = destination,
                favoriteCount = favoriteCount,
                onClick = {
                    destination.route?.let {
                        navController.navigate(it)
                    }
                }
            )
        }
    }
}

/**
 * Вкладка меню
 *
 * @param isSelected true если сейчас открыт данный экран, false - иначе
 * @param destination информация об экране, соответствующем данной вкладке
 *
 * @author Михаил Гонтарев (KiREHwYE)
 * */
@Composable
private fun BottomTab(
    isSelected: Boolean,
    destination: MenuDestinations,
    favoriteCount: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_3)
    ) {

        Box(modifier = Modifier.wrapContentSize()) {
            Icon(
                painter = painterResource(destination.icon),
                contentDescription = "Menu icon",
                tint = if (isSelected)
                    extendedColor.blue
                else extendedColor.grey4

            )

            // Кружок с количеством вакансий в избранном
            if (favoriteCount > 0 && destination.route == JobsRoutes.Main.route) {
                Box(
                    modifier = Modifier
                        .size(13.dp)
                        .clip(CircleShape)
                        .background(extendedColor.red)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = favoriteCount.toString(),
                        style = extendedType.number,
                        color = Color.White
                    )
                }
            }
        }

        // Название вкладки (экрана)
        Text(
            text = destination.label,
            style = extendedType.tabText,
            color = if (isSelected)
                extendedColor.blue
            else extendedColor.grey4
        )
    }
}