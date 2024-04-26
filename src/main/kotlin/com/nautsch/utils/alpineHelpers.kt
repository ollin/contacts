package com.nautsch.utils

fun alpineJsDispatch(eventName: String): String {
    return "\$dispatch('$eventName');"
}

class  AttributeValue<T>(val name: String, var value: T) {
    override fun toString(): String {
        return "$name = $value"
    }
}



