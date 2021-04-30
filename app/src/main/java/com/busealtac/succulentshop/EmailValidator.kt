package com.busealtac.succulentshop

class EmailValidator : Validator {

    override fun validate(field: String): Int? = when {
        field.isEmpty() -> R.string.email_is_required
        field.length < 5 || field.length > 50 -> R.string.email_is_invalid
        !field.contains('@') -> R.string.email_is_invalid
        !field.contains('.') -> R.string.email_is_invalid
        else -> null
    }
}


