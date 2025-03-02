package com.kire.ui.util

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp

/**
 * Позволяет проигнорировать родителский паддинг
 *
 * @param vertical величина паддинга, которую нужно компенсировать
 *
 * @author Михаил Гонтарев (KiREHwYE)
 */
fun Modifier.ignoreVerticalParentPadding(vertical: Dp): Modifier {
    return this.layout { measurable, constraints ->
        val overridenHeight = constraints.maxHeight + 2 * vertical.roundToPx()
        val placeable = measurable.measure(constraints.copy(maxHeight = overridenHeight))
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}