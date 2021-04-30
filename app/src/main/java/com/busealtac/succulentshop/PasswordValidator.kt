package com.busealtac.succulentshop

class PasswordValidator : Validator {

    override fun validate(field: String): Int? = when {
        field.isEmpty() -> R.string.password_is_required
        field.length < 7 -> R.string.password_is_too_short
        field.length > 40 -> R.string.password_is_too_long
        !(field.any { it.isLetter() && it.isUpperCase() }
                && field.any { it.isLetter() && it.isLowerCase() }
                && field.any { it.isDigit() }
                && field.any { !it.isLetterOrDigit() })
        -> R.string.password_must_contain_one_digit_one_uppercase_letter_one_lowercase_letter_and_one_special_character

        else -> null
    }
}



