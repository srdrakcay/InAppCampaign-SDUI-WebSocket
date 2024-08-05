package com.serdar.inappcampaign_sdui_websocket.feature

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class CustomCardShape(
    private val cardHeight: Dp = 250.dp,
    private val shift: Dp = 20.dp,
    private val cornerRadius: Dp = 10.dp

) : Shape {

    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ): Outline {
        val cardHeightPx = cardHeight.toPx(density)
        val shiftPx = shift.toPx(density)
        val cornerRadiusPx = cornerRadius.toPx(density)
        val path = Path().apply {
            moveTo(shiftPx, 0f)
            lineTo(size.width, 0f)
            lineTo(size.width - shiftPx, cardHeightPx)
            lineTo(0f, cardHeightPx)
            close()

        }

        return Outline.Generic(path)
    }
}


fun Dp.toPx(density: Density): Float {
    return with(density) { toPx() }
}
