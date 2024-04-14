package com.nautsch.contacts

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.webjars.*

fun Application.configureRouting() {

    val repo = ContactRepository()

    install(Webjars) {
        path = "/webjars" //defaults to /webjars
    }
    routing {
        get("/") {
            call.respondRedirect("/contacts")
        }

        route("/contacts") {
            get  {
                call.respondHtml(HttpStatusCode.OK) {
                    contacts(repo.listAll())
                }
            }
        }
        get("/webjars") {
            call.respondText("<script src='/webjars/jquery/jquery.js'></script>", ContentType.Text.Html)
        }

        staticResources("/public/css" , "public.css")
        staticResources("/public/images" , "public.images")


    }
}
