package com.nautsch.contacts

import com.nautsch.utils.UuidAsString

data class Contact(
    val id: UuidAsString,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val postalCode: String,
)