package com.busealtac.succulentshop

interface Validator {
    fun validate(field: String): Int?

}