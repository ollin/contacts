package com.nautsch.contacts

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.webjars.*

fun Application.configureRouting() {

    val repo = ContactRepository()

    install(Webjars) {
        path = "/webjars" //defaults to /webjars
    }
    install(Resources)

    routing {
        get<Contacts> { contacts ->
            call.respondHtml(HttpStatusCode.OK) {
                contacts(repo.listAll())
            }
        }
        delete<Contacts.Id> { contact ->
            repo.delete(contact.id)

            call.response.header(HttpHeaders.Location, application.href<Contacts>(Contacts()))
            call.respond(
                HttpStatusCode.SeeOther,
            )
        }



        get("/") {
            call.respondRedirect("/contacts")
        }

        get("/webjars") {
            call.respondText("<script src='/webjars/jquery/jquery.js'></script>", ContentType.Text.Html)
        }

        staticResources("/public/css", "public.css")
        staticResources("/public/images", "public.images")


    }
}
