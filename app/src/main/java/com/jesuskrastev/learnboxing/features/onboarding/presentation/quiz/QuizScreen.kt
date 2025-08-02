package com.jesuskrastev.learnboxing.features.onboarding.presentation.quiz

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Title(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Entrena de la forma correcta",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun Subtitle(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "¿Y tú, cómo estás aprendiendo boxeo?",
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
    )
}

@Composable
fun Description(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "La forma más clara y efectiva de aprender boxeo.",
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
    )
}

@Composable
fun OptionCard(
    text: String,
    selected: Boolean,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = if (selected) Color(0xFF4CAF50) else MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(12.dp)
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OptionDetails(
            text = text,
            selected = selected,
        )
    }
}

@Composable
fun OptionDetails(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = 12.dp,
                horizontal = 16.dp,
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OptionLabel(
            modifier = Modifier.weight(1f),
            text = text,
        )
        OptionRadioButton(
            selected = selected,
        )
    }
}

@Composable
fun OptionRadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
) {
    RadioButton(
        modifier = modifier,
        colors = RadioButtonDefaults.colors(
            selectedColor = Color(0xFF4CAF50),
        ),
        selected = selected,
        onClick = {},
    )
}

@Composable
fun OptionLabel(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.Medium,
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Composable
fun Options(
    modifier: Modifier = Modifier,
) {
    @Immutable
    data class OptionState(
        val text: String,
        val selected: Boolean,
    )

    val options = listOf(
        OptionState(text = "Usando esta app", selected = true),
        OptionState(text = "Viendo vídeos en YouTube", selected = false),
        OptionState(text = "En clases presenciales", selected = false),
        OptionState(text = "Con un amigo que sabe boxear", selected = false),
    )

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(options) { option ->
            OptionCard(
                text = option.text,
                selected = option.selected,
            )
        }
    }
}

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Title()
        Subtitle()
        Options()
        Description()
    }
}