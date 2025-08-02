package com.jesuskrastev.learnboxing.features.onboarding.presentation.question

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jesuskrastev.learnboxing.features.onboarding.domain.question.QuestionState

@Composable
fun QuestionScreen(
    modifier: Modifier = Modifier,
    questionState: QuestionState,
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Question(
            text = questionState.question,
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(questionState.answers) { answer ->
                OptionCard(
                    text = answer.answer,
                    selected = answer.selected,
                    onClick = {},
                    isMultipleChoice = questionState.isMultipleChoice,
                )
            }
        }
    }
}

@Composable
fun Question(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.ExtraBold,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun OptionCard(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    isMultipleChoice: Boolean,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OptionDetails(
            text = text,
            selected = selected,
            onClick = onClick,
            isMultipleChoice = isMultipleChoice,
        )
    }
}

@Composable
fun OptionDetails(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    isMultipleChoice: Boolean,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = 6.dp,
                horizontal = 16.dp,
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OptionLabel(
            text = text,
        )
        if(isMultipleChoice)
            Checkbox(
                checked = selected,
                onCheckedChange = { onClick() },
            )
        else
            RadioButton(
                selected = selected,
                onClick = onClick,
            )
    }
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