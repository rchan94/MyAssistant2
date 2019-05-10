package com.example.myassistant.finance

data class Payment(
    val day: Int,
    val amount: Double,
    val variableAmount: Boolean = false,
    val description: String = "",
    val type: Type = Type.MONEY
)

enum class Type {
    CAR,
    MUSIC,
    MONEY,
    PHONE,
    SPORTS,
    TV
}
