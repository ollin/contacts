package com.nautsch.contacts

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    mapOf(
        "java.rmi.server.hostname" to "127.0.0.1",
        "com.sun.management.jmxremote.local.only" to "false",
        "java.net.preferIPv4Stack" to "true",
        "java.rmi.server.useLocalHostname" to "true"
    ).forEach { (key, value) ->
        System.setProperty(key, value)
    }

    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureTemplating()
    configureRouting(this@module)
}
