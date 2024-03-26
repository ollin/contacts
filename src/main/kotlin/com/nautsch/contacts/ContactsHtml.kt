package com.nautsch.contacts

import kotlinx.html.*

fun HTML.contacts() {
    head {
        meta {
            charset = "UTF-8"
            name = "viewport"
            content = "width=device-width, initial-scale=1, shrink-to-fit=no"
            script { type = ScriptType.textJavaScript; src = "/webjars/bootstrap/js/bootstrap.min.js" }
            script { type = ScriptType.textJavaScript; src = "/webjars/htmx.org/dist/htmx.min.js" }

            link { rel = ARel.stylesheet; href = "/webjars/bootstrap-icons/font/bootstrap-icons.css" }
            link { rel = ARel.stylesheet; href = "/webjars/bootstrap/css/bootstrap.min.css" }

        }

        link {

        }

    }
    body {
        attributes["hx-boost"] = "true"

        nav {
            classes = setOf("navbar", "bg-body-tertiary")

            a {
                classes = setOf("navbar-brand")
                href = "#"
                +"Contacts"
            }
        }


        // content
        img {
            alt = "Loading..."
            classes = setOf("htmx-indicator")
        }

    }
}