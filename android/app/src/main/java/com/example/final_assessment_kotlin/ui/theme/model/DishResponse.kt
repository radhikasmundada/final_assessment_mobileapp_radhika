package com.example.final_assessment_kotlin.ui.theme.model

data class DishResponse(
    val message: String,
    val payload: List<Payload>,
    val status: String
)