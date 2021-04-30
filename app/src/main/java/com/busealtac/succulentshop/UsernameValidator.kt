package com.busealtac.succulentshop


class UsernameValidator : Validator {

    override fun validate(field: String): Int? = when {
        field.isEmpty() -> R.string.username_is_required
        field.length < 2 -> R.string.username_is_too_short
        field.length > 20 -> R.string.username_is_too_long
        !(field.any { it.isDigit() } &&
                field.contains('_') &&
                field.all { if (it.isLetter()) it.isLowerCase() else true }) -> R.string.username_can_only_include_a_z_0_9_and_characters

        else -> null
    }
}

