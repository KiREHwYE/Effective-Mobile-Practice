package com.kire.jobs.presentation.screen.vacancy_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kire.jobs.presentation.constant.JobsDimens.AVATAR_SIZE
import com.kire.jobs.presentation.constant.JobsStrings.ADD_COVER_LETTER
import com.kire.jobs.presentation.constant.JobsStrings.RESUME_FOR_APPLY
import com.kire.ui.Dimens.HORIZONTAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_16
import com.kire.ui.Dimens.VERTICAL_PAD_20
import com.kire.ui.Dimens.VERTICAL_PAD_24
import com.kire.ui.Dimens.VERTICAL_PAD_40
import com.kire.ui.Dimens.VERTICAL_PAD_8
import com.kire.ui.theme.ExtendedTheme.extendedColor
import com.kire.ui.theme.ExtendedTheme.extendedType
import com.kire.vacancies.R


/**
 * Всплывашка с предложением ввести сопроводительное письмо
 *
 * @param isVisible флаг видимости
 * @param vacancyTitle название вакансии
 * @param onDismiss действие при клике снаружи всплывышки
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VacancyApplyBottomSheet(
    isVisible: Boolean,
    vacancyTitle: String,
    onDismiss: () -> Unit
) {
    if (isVisible) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            containerColor = extendedColor.black,
            scrimColor = extendedColor.black.copy(alpha = 0.5f)
        ) {
            ResponseSheetContent(vacancyTitle = vacancyTitle)
        }
    }
}

/**
 * Содержимое всплывашки
 *
 * @param vacancyTitle название вакансии
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
private fun ResponseSheetContent(vacancyTitle: String) {

    var isEditing by rememberSaveable { mutableStateOf(false) }
    var coverLetter by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = HORIZONTAL_PAD_16, VERTICAL_PAD_16),
        verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_40)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_24)
        ) {
            ResumeInfo(vacancyTitle)

            HorizontalDivider(
                thickness = 1.dp,
                color = extendedColor.grey2,
                modifier = Modifier
                    .fillMaxWidth()
            )

            if (isEditing)
                BasicTextField(
                    value = coverLetter,
                    onValueChange = { coverLetter = it },
                    textStyle = extendedType.text1.copy(color = extendedColor.white),
                    cursorBrush = SolidColor(extendedColor.grey3),
                    decorationBox = { innerTextField ->
                        if (isEditing && coverLetter.isEmpty())
                            Text(
                                text = "Ваше сопроводительное",
                                style = extendedType.text1,
                                color = extendedColor.grey3
                            )
                        else innerTextField()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
        }


        Column(
            verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_20)
        ) {
            if (!isEditing)
                AddCoverLetter(
                    onClick = {
                        isEditing = !isEditing
                    }
                )
            VacancyApplyButton()
        }
    }
}

/**
 * Аватарка пользователя и  название вакансии
 *
 * @param vacancyTitle название вакансии
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
private fun ResumeInfo(
    vacancyTitle: String
) {

    Box(
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(HORIZONTAL_PAD_16)
        ) {

            Image(
                painter = painterResource(R.drawable.avatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(AVATAR_SIZE)
                    .clip(CircleShape)
            )

            Column(
                modifier =  Modifier
                    .wrapContentSize(),
                verticalArrangement = Arrangement.spacedBy(VERTICAL_PAD_8)
            ) {
                Text(
                    text = RESUME_FOR_APPLY,
                    style = extendedType.text1,
                    color = extendedColor.grey3
                )
                Text(
                    text = vacancyTitle,
                    style = extendedType.title3,
                    color = extendedColor.white
                )
            }
        }
    }
}


/**
 * Кнопка в виде текста, по нажатию на которую
 * появляется текстовое поле для ввода сопроводительного
 *
 * @param vacancyTitle название вакансии
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
@Composable
private fun AddCoverLetter(
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = ADD_COVER_LETTER,
            style = extendedType.buttonText1,
            color = extendedColor.green
        )
    }
}