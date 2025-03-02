package com.kire.jobs.presentation.topblock

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.kire.jobs.presentation.constant.JobsDimens.OFFER_ICON_SIZE
import com.kire.jobs.presentation.constant.JobsDimens.OFFER_WIDTH
import com.kire.jobs.presentation.model.offer.Offer
import com.kire.ui.Dimens.HORIZONTAL_PAD_16
import com.kire.ui.Dimens.HORIZONTAL_PAD_8
import com.kire.ui.Dimens.VERTICAL_PAD_10
import com.kire.ui.theme.extendedColor
import com.kire.ui.theme.extendedType
import com.kire.ui.ui_component.Tile
import com.kire.ui.util.bounceClick
import com.kire.ui.util.ignoreHorizontalParentPadding
import com.kire.vacancies.R


/**
 * Карусель предложений
 *
 * @param modifier модификатор
 * @param offers список предложений для отображения
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
fun OffersCarousel(
    modifier: Modifier = Modifier,
    offers: List<Offer> = emptyList()
) {
    /** Контекст для intent, чтобы перейти по ссылке */
    val context = LocalContext.current

    /** Возвращает DrawableRes иконки на основании offer.id */
    val chooseIconById: (String) -> Int = { id ->
        when(id) {
            "near_vacancies" -> R.drawable.near_vacancies
            "level_up_resume" -> R.drawable.level_up_resume
            else -> R.drawable.temporary_job
        }
    }
    /** Возвращает Color фона иконки на основании offer.id */
    val chooseIconBackgroundById: (String) -> Color = { id ->
        when(id) {
            "near_vacancies" -> extendedColor.darkBlue
            else -> extendedColor.darkGreen
        }
    }

    /** Возвращает Color иконки на основании offer.id */
    val chooseIconColorById: (String) -> Color = { id ->
        when(id) {
            "near_vacancies" -> extendedColor.blue
            else -> extendedColor.green
        }
    }

    /** Чтобы выравнять все плитки под один размер */
    var maxHeight by rememberSaveable { mutableStateOf(0) }

    LazyRow(
        modifier = modifier
            .ignoreHorizontalParentPadding(HORIZONTAL_PAD_16)
            .fillMaxWidth()
            .wrapContentHeight(),
        contentPadding = PaddingValues(horizontal = HORIZONTAL_PAD_16),
        horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_8),
        verticalAlignment = Alignment.CenterVertically
    ) {

        items(offers) { offer ->

            Tile(
                modifier = Modifier
                    .then(
                        if (maxHeight == 0)
                            Modifier.wrapContentHeight()
                        else Modifier.height(with(LocalDensity.current) { maxHeight.toDp() })
                    )
                    .width(OFFER_WIDTH)
                    .onGloballyPositioned { coordinates ->
                        maxHeight = maxOf(maxHeight, coordinates.size.height)
                    }
                    .bounceClick {
                        // Переходим по ссылке
                        offer.link?.let { url ->
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)
                        }
                    },
                paddingValues = PaddingValues(
                    vertical = VERTICAL_PAD_10,
                    horizontal = HORIZONTAL_PAD_8
                )
            ) {
                // Иконка
                offer.id?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.TopStart
                    ) {
                        Box(
                            modifier = Modifier
                                .size(OFFER_ICON_SIZE)
                                .clip(CircleShape)
                                .background(color = chooseIconBackgroundById(it)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(chooseIconById(it)),
                                contentDescription = "Offer icon",
                                tint = chooseIconColorById(it)
                            )
                        }
                    }
                }

                // Текст
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = offer.title?.trim() ?: "",
                        maxLines = if (offer.button?.text.isNullOrEmpty()) 3 else 2,
                        overflow = TextOverflow.Ellipsis,
                        style = extendedType.title4,
                        color = extendedColor.white
                    )

                    offer.button?.let {
                        Text(
                            text = it.text ?: "",
                            style = extendedType.text1,
                            color = extendedColor.green
                        )
                    }
                }
            }
        }
    }
}