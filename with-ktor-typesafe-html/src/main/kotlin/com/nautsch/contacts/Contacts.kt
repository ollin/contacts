package com.nautsch.contacts

import com.nautsch.utils.UuidAsString
import io.ktor.resources.*

@Resource("contacts")
class Contacts {
    @Resource("{id}")
    class Id(val parent: Contacts = Contacts(), val id: UuidAsString)
}