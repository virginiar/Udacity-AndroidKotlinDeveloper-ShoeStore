package com.udacity.shoestore.utils

import android.widget.EditText
import androidx.databinding.InverseMethod

object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(
        value: Double
    ): String {
        // Converts double to String.
        return value.toString()
    }

    @JvmStatic fun stringToDouble(
        value: String
    ): Double {
        // Converts String to double.
        return value.toDoubleOrNull() ?: 0.0
    }
}