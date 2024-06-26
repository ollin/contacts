package com.nautsch.contacts

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*


class ApplicationTest : StringSpec({

    "get / returns okay" {
        testApplication {
            application {
                configureRouting(this)
            }
            client.get("/").apply {

                status shouldBe HttpStatusCode.OK
            }
        }
    }
})


