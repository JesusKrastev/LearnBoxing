package com.jesuskrastev.learnboxing.features.onboarding.presentation.chart

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.models.AnimationMode
import ir.ehsannarmani.compose_charts.models.DividerProperties
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.HorizontalIndicatorProperties
import ir.ehsannarmani.compose_charts.models.LabelHelperProperties
import ir.ehsannarmani.compose_charts.models.LabelProperties
import ir.ehsannarmani.compose_charts.models.Line
import ir.ehsannarmani.compose_charts.models.PopupProperties
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sin

@Composable
fun ChartTitle(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Progreso de boxeo",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun ChartSubtitle(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "\uD83D\uDCC8 Aprende paso a paso con una ruta de aprendizaje guiado.",
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.outline,
    )
}

@Composable
fun Chart(
    modifier: Modifier = Modifier,
) {
    LineChart(
        modifier = modifier.size(300.dp),
        dividerProperties = DividerProperties(
            enabled = false,
        ),
        indicatorProperties = HorizontalIndicatorProperties(
            enabled = false,
        ),
        labelProperties = LabelProperties(
            enabled = true,
            labels = listOf("0m", "3m", "6m", "9m", "12m"),
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.outline,
            ),
        ),
        popupProperties = PopupProperties(
            enabled = false,
        ),
        labelHelperProperties = LabelHelperProperties(
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onBackground
            ),
        ),
        data = remember {
            listOf(
                Line(
                    label = "Con esta app",
                    values = (1..400).map { it.toDouble().pow(0.6) },
                    color = SolidColor(Color(0xFFFF0700)),
                    strokeAnimationSpec = tween(2000, easing = EaseInOutCubic),
                    gradientAnimationDelay = 1000,
                    drawStyle = DrawStyle.Stroke(width = 6.dp),
                ),
                Line(
                    label = "Método tradicional",
                    values = (40..250).map { x ->
                        val x = x.toDouble()
                        val base = x.pow(0.55) * 0.6
                        val bump1 = 1 + 0.06 * sin(0.02 * x) * exp(-0.002 * x)
                        val bump2 = 8.0 * exp(-((x - 160.0).pow(2) / (2 * 60.0.pow(2))))
                        base * bump1 + bump2
                    },
                    color = SolidColor(Color(0xFF2979FF)),
                    strokeAnimationSpec = tween(2000, easing = EaseInOutCubic),
                    gradientAnimationDelay = 1000,
                    drawStyle = DrawStyle.Stroke(width = 6.dp),
                ),
            )
        },
        animationMode = AnimationMode.Together(
            delayBuilder = {
                it * 500L
            }
        ),
    )
}

@Composable
fun ChartScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ChartTitle()
        Chart()
        ChartSubtitle()
    }
}