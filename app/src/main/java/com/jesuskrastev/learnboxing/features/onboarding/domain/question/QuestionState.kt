package com.jesuskrastev.learnboxing.features.onboarding.domain.question

data class QuestionState(
    val question: String,
    val answers: List<AnswerState>,
    val isMultipleChoice: Boolean,
)
