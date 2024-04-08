package com.nautsch.contacts

import java.util.UUID

data class Contact(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
)