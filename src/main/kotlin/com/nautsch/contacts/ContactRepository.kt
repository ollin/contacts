package com.nautsch.contacts

import io.github.serpro69.kfaker.Faker
import java.util.*

class ContactRepository {

    private var idContactMap: Map<UUID, Contact>

    init {
        val faker = Faker()
        val tmpIdContactMap = mutableMapOf<UUID, Contact>()
        (1..100).forEach {
            val tmpFirstName = faker.name.firstName()
            val tmpLastName = faker.name.lastName()
            val tmpId = UUID.randomUUID()
            tmpIdContactMap.put(
                tmpId,
                Contact(
                    id = tmpId,
                    firstName = tmpFirstName,
                    lastName = tmpLastName,
                    email = faker.internet.safeEmail("${tmpFirstName}.${tmpLastName}".replace(" ", "")),
                    phone = faker.phoneNumber.phoneNumber()
                )
            )
        }

        idContactMap = tmpIdContactMap
    }

    fun listAll(): List<Contact> {
        return idContactMap.values.toList()
    }
}