package com.kire.effectivemobilepractice

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kire.ui.Dimens.HORIZONTAL_PAD_14
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_3
import com.kire.ui.Dimens.VERTICAL_PAD_6
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.util.ignoreVerticalParentPadding

/**
 * Меню навигации по приложению
 *
 * @param navController для навигации
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun BottomMenu(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    /** Текущий route */
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

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
            BottomTab(
                isSelected = currentRoute == destination.route,
                destination = destination,
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
    onClick: () -> Unit
) {
    Column (
        modifier = Modifier
            .wrapContentSize()
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_3)
    ) {

        Icon(
            painter = painterResource(destination.icon),
            contentDescription = "Menu icon",
            tint = if (isSelected)
                extendedColor.blue
            else extendedColor.grey4

        )

        Text(
            text = destination.label,
            style = extendedType.tabText,
            color = if (isSelected)
                extendedColor.blue
            else extendedColor.grey4
        )
    }
}