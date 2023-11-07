package com.lutech.aiart.extentionFunction

import java.text.NumberFormat
import java.util.Locale

fun Long.formatCurrencyVie(amountOfMoney:Long): String{
    return NumberFormat.getCurrencyInstance(Locale("vie","vn")).format(amountOfMoney)
}