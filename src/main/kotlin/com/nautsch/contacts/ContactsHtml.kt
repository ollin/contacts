package com.nautsch.contacts

import kotlinx.html.*
import kotlinx.html.ButtonType.button
import kotlinx.html.ThScope.col

fun HTML.contacts() {
    classes = setOf("h-full", "bg-gray-100")

    head {
        meta {
            charset = "UTF-8"
            name = "viewport"
            content = "width=device-width, initial-scale=1, shrink-to-fit=no"
            script { type = ScriptType.textJavaScript; src = "/webjars/bootstrap/js/bootstrap.min.js" }
            script { type = ScriptType.textJavaScript; src = "/webjars/htmx.org/dist/htmx.min.js" }
            script { type = ScriptType.textJavaScript; src = "/webjars/alpinejs/dist/cdn.js"; defer = true }

            link { rel = ARel.stylesheet; href = "/public/css/output.css" }
        }
    }



    body(classes = "h-full") {
        attributes["hx-boost"] = "true"

        div(classes = "min-h-full") {
            nav(classes = "bg-gray-800") {
                div("mx-auto max-w-7xl px-4 sm:px-6 lg:px-8") {
                    div("flex h-16 items-center justify-between") {
                        div("flex items-center") {
                            div("flex-shrink-0") {
                                img(classes = "h-8 w-8") {
                                    src = "public/images/contacts.svg"
                                    alt = "Your Company"
                                }
                            }
                            div("hidden md:block") {
                                div("ml-10 flex items-baseline space-x-4") {
//                                    +"""<!-- Current: "bg-gray-900 text-white", Default: "text-gray-300 hover:bg-gray-700 hover:text-white" -->"""
                                    a(classes = "bg-gray-900 text-white rounded-md px-3 py-2 text-sm font-medium") {
                                        href = "#"
                                        attributes["aria-current"] = "page"
                                        +"""Dashboard"""
                                    }
                                    a(classes = "text-gray-300 hover:bg-gray-700 hover:text-white rounded-md px-3 py-2 text-sm font-medium") {
                                        href = "#"
                                        +"""Team"""
                                    }
                                    a(classes = "text-gray-300 hover:bg-gray-700 hover:text-white rounded-md px-3 py-2 text-sm font-medium") {
                                        href = "#"
                                        +"""Projects"""
                                    }
                                    a(classes = "text-gray-300 hover:bg-gray-700 hover:text-white rounded-md px-3 py-2 text-sm font-medium") {
                                        href = "#"
                                        +"""Calendar"""
                                    }
                                    a(classes = "text-gray-300 hover:bg-gray-700 hover:text-white rounded-md px-3 py-2 text-sm font-medium") {
                                        href = "#"
                                        +"""Reports"""
                                    }
                                }
                            }
                        }
                        div("hidden md:block") {
                            div("ml-4 flex items-center md:ml-6") {
                                button(classes = "relative rounded-full bg-gray-800 p-1 text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800") {
                                    type = button
                                    span("absolute -inset-1.5") {
                                    }
                                    span("sr-only") { +"""View notifications""" }
                                    svg("h-6 w-6") {
                                        attributes["fill"] = "none"
                                        attributes["viewbox"] = "0 0 24 24"
                                        attributes["stroke-width"] = "1.5"
                                        attributes["stroke"] = "currentColor"
                                        attributes["aria-hidden"] = "true"
                                        unsafe { +"""<path stroke-linecap="round" stroke-linejoin="round" d="M14.857 17.082a23.848 23.848 0 005.454-1.31A8.967 8.967 0 0118 9.75v-.7V9A6 6 0 006 9v.75a8.967 8.967 0 01-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 01-5.714 0m5.714 0a3 3 0 11-5.714 0"></path>""" }
                                    }
                                }
//                                +"""<!-- Profile dropdown -->"""
                                div("relative ml-3") {
                                    attributes["x-data"] = "{ open: false }"
                                    attributes["x-on:mouseenter"] = "open = true"
                                    attributes["x-on:mouseleave"] = "open = false"
                                    attributes["x-on:click.away"] = "open = false"

                                    div {
                                        button(classes = "relative flex max-w-xs items-center rounded-full bg-gray-800 text-sm text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800") {
                                            type = button
                                            id = "user-menu-button"
                                            attributes["aria-expanded"] = "false"
                                            attributes["aria-haspopup"] = "true"
                                            span("absolute -inset-1.5") {
                                            }
                                            span("sr-only") { +"""Open user menu""" }
                                            img(classes = "h-8 w-8 rounded-full") {
                                                src =
                                                    "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"
                                                alt = ""
                                            }
                                        }
                                    }
//                                    +"""<!--
//                Dropdown menu, show/hide based on menu state.
//
//                Entering: "transition ease-out duration-100"
//                  From: "transform opacity-0 scale-95"
//                  To: "transform opacity-100 scale-100"
//                Leaving: "transition ease-in duration-75"
//                  From: "transform opacity-100 scale-100"
//                  To: "transform opacity-0 scale-95"
//              -->"""
                                    div("absolute right-0 z-10 mt-2 w-48 origin-top-right rounded-md bg-white py-1 shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none") {
                                        role = "menu"
                                        attributes["aria-orientation"] = "vertical"
                                        attributes["aria-labelledby"] = "user-menu-button"
                                        attributes["tabindex"] = "-1"

                                        attributes["x-show"] = "open"
                                        attributes["x-transition:enter"] = "transition ease-out duration-100"
                                        attributes["x-transition:enter-start"] = "opacity-0 scale-95"
                                        attributes["x-transition:enter-end"] = "opacity-100 scale-100"
                                        attributes["x-transition:leave"] = "transition ease-in duration-75"
                                        attributes["x-transition:leave-start"] = "opacity-100 scale-100"
                                        attributes["x-transition:leave-end"] = "opacity-0 scale-95"

//                                        +"""<!-- Active: "bg-gray-100", Not Active: "" -->"""
                                        a(classes = "block px-4 py-2 text-sm text-gray-700") {
                                            href = "#"
                                            role = "menuitem"
                                            attributes["tabindex"] = "-1"
                                            id = "user-menu-item-0"
                                            +"""Your Profile"""
                                        }
                                        a(classes = "block px-4 py-2 text-sm text-gray-700") {
                                            href = "#"
                                            role = "menuitem"
                                            attributes["tabindex"] = "-1"
                                            id = "user-menu-item-1"
                                            +"""Settings"""
                                        }
                                        a(classes = "block px-4 py-2 text-sm text-gray-700") {
                                            href = "#"
                                            role = "menuitem"
                                            attributes["tabindex"] = "-1"
                                            id = "user-menu-item-2"
                                            +"""Sign out"""
                                        }
                                    }
                                }
                            }
                        }
                        div("-mr-2 flex md:hidden") {
//                            +"""<!-- Mobile menu button -->"""
                            button(classes = "relative inline-flex items-center justify-center rounded-md bg-gray-800 p-2 text-gray-400 hover:bg-gray-700 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800") {
                                type = button
                                attributes["aria-controls"] = "mobile-menu"
                                attributes["aria-expanded"] = "false"
                                span("absolute -inset-0.5") {
                                }
                                span("sr-only") { +"""Open main menu""" }
//                                +"""<!-- Menu open: "hidden", Menu closed: "block" -->"""
                                svg("block h-6 w-6") {
                                    attributes["fill"] = "none"
                                    attributes["viewbox"] = "0 0 24 24"
                                    attributes["stroke-width"] = "1.5"
                                    attributes["stroke"] = "currentColor"
                                    attributes["aria-hidden"] = "true"
                                    unsafe { +"""<path stroke-linecap="round" stroke-linejoin="round" d="M14.857 17.082a23.848 23.848 0 005.454-1.31A8.967 8.967 0 0118 9.75v-.7V9A6 6 0 006 9v.75a8.967 8.967 0 01-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 01-5.714 0m5.714 0a3 3 0 11-5.714 0" />""" }
                                }
//                                +"""<!-- Menu open: "block", Menu closed: "hidden" -->"""
                                svg("hidden h-6 w-6") {
                                    attributes["fill"] = "none"
                                    attributes["viewbox"] = "0 0 24 24"
                                    attributes["stroke-width"] = "1.5"
                                    attributes["stroke"] = "currentColor"
                                    attributes["aria-hidden"] = "true"
                                    unsafe { +"""<path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />""" }
                                }
                            }
                        }
                    }
                }
//                +"""<!-- Mobile menu, show/hide based on menu state. -->"""
                div("md:hidden") {
                    id = "mobile-menu"
                    div("space-y-1 px-2 pb-3 pt-2 sm:px-3") {
//                        +"""<!-- Current: "bg-gray-900 text-white", Default: "text-gray-300 hover:bg-gray-700 hover:text-white" -->"""
                        a(classes = "bg-gray-900 text-white block rounded-md px-3 py-2 text-base font-medium") {
                            href = "#"
                            attributes["aria-current"] = "page"
                            +"""Dashboard"""
                        }
                        a(classes = "text-gray-300 hover:bg-gray-700 hover:text-white block rounded-md px-3 py-2 text-base font-medium") {
                            href = "#"
                            +"""Team"""
                        }
                        a(classes = "text-gray-300 hover:bg-gray-700 hover:text-white block rounded-md px-3 py-2 text-base font-medium") {
                            href = "#"
                            +"""Projects"""
                        }
                        a(classes = "text-gray-300 hover:bg-gray-700 hover:text-white block rounded-md px-3 py-2 text-base font-medium") {
                            href = "#"
                            +"""Calendar"""
                        }
                        a(classes = "text-gray-300 hover:bg-gray-700 hover:text-white block rounded-md px-3 py-2 text-base font-medium") {
                            href = "#"
                            +"""Reports"""
                        }
                    }
                    div("border-t border-gray-700 pb-3 pt-4") {
                        div("flex items-center px-5") {
                            div("flex-shrink-0") {
                                img(classes = "h-10 w-10 rounded-full") {
                                    src =
                                        "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"
                                    alt = ""
                                }
                            }
                            div("ml-3") {
                                div("text-base font-medium text-white") { +"""Tom Cook""" }
                                div("text-sm font-medium text-gray-400") { +"""tom@example.com""" }
                            }
                            button(classes = "relative ml-auto flex-shrink-0 rounded-full bg-gray-800 p-1 text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800") {
                                type = button
                                span("absolute -inset-1.5") {
                                }
                                span("sr-only") { +"""View notifications""" }
                                svg("h-6 w-6") {
                                    attributes["fill"] = "none"
                                    attributes["viewbox"] = "0 0 24 24"
                                    attributes["stroke-width"] = "1.5"
                                    attributes["stroke"] = "currentColor"
                                    attributes["aria-hidden"] = "true"
                                    +"""<path stroke-linecap="round" stroke-linejoin="round" d="M14.857 17.082a23.848 23.848 0 005.454-1.31A8.967 8.967 0 0118 9.75v-.7V9A6 6 0 006 9v.75a8.967 8.967 0 01-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 01-5.714 0m5.714 0a3 3 0 11-5.714 0" />"""
                                }
                            }
                        }
                        div("mt-3 space-y-1 px-2") {
                            a(classes = "block rounded-md px-3 py-2 text-base font-medium text-gray-400 hover:bg-gray-700 hover:text-white") {
                                href = "#"
                                +"""Your Profile"""
                            }
                            a(classes = "block rounded-md px-3 py-2 text-base font-medium text-gray-400 hover:bg-gray-700 hover:text-white") {
                                href = "#"
                                +"""Settings"""
                            }
                            a(classes = "block rounded-md px-3 py-2 text-base font-medium text-gray-400 hover:bg-gray-700 hover:text-white") {
                                href = "#"
                                +"""Sign out"""
                            }
                        }
                    }
                }
            }


            header(classes = "bg-white shadow-sm") {
                div(classes = "mx-auto max-w-7xl px-4 py-4 sm:px-6 lg:px-8") {
                    h1(classes = "text-lg font-semibold leading-6 text-gray-900") { +"""Dashboard""" }
                }
            }
            main {
                div(classes = "mx-auto max-w-7xl py-6") {


                    div(classes = "px-4 sm:px-6 lg:px-8") {
                        div(classes = "sm:flex sm:items-center") {
                            div(classes = "sm:flex-auto") {
                                h1(classes = "text-base font-semibold leading-6 text-gray-900") { +"""Contacts""" }
                                p(classes = "mt-2 text-sm text-gray-700") { +"""A list of all the contacts in your account including their name, email and phone.""" }
                            }
                            div(classes = "mt-4 sm:ml-16 sm:mt-0 sm:flex-none") {
                                button(classes = "block rounded-md bg-indigo-600 px-3 py-2 text-center text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600") {
                                    type = button
                                    +"""Add contact"""
                                }
                            }
                        }
                        div("mt-8 flow-root") {
                            div("-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8") {
                                div("inline-block min-w-full py-2 align-middle sm:px-6 lg:px-8") {
                                    div("overflow-hidden shadow ring-1 ring-black ring-opacity-5 sm:rounded-lg") {
                                        table("min-w-full divide-y divide-gray-300") {
                                            thead("bg-gray-50") {
                                                tr {
                                                    th(classes = "py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-6") {
                                                        scope = col
                                                        +"""First Name"""
                                                    }
                                                    th(classes = "px-3 py-3.5 text-left text-sm font-semibold text-gray-900") {
                                                        scope = col
                                                        +"""Last Name"""
                                                    }
                                                    th(classes = "px-3 py-3.5 text-left text-sm font-semibold text-gray-900") {
                                                        scope = col
                                                        +"""Email"""
                                                    }
                                                    th(classes = "px-3 py-3.5 text-left text-sm font-semibold text-gray-900") {
                                                        scope = col
                                                        +"""Phone"""
                                                    }
                                                    th(classes = "relative py-3.5 pl-3 pr-4 sm:pr-6") {
                                                        scope = col
                                                        span("sr-only") { +"""Edit""" }
                                                    }
                                                }
                                            }
                                            tbody("divide-y divide-gray-200 bg-white") {
                                                tr {
                                                    td("whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6") { +"""Oliver""" }
                                                    td("whitespace-nowrap px-3 py-4 text-sm text-gray-900") { +"""Nautsch""" }
                                                    td("whitespace-nowrap px-3 py-4 text-sm text-gray-900") { +"""oliver@email.local""" }
                                                    td("whitespace-nowrap px-3 py-4 text-sm text-gray-900") { +"""+41 79 555 55 55""" }
                                                    td("relative whitespace-nowrap py-4 pl-3 pr-4 text-right text-sm font-medium sm:pr-6") {
                                                        a(classes = "text-indigo-600 hover:text-indigo-900") {
                                                            href = "#"
                                                            +"""Edit"""
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }




                }
            }

        }


        // content
        img(classes = "htmx-indicator") {
            alt = "Loading..."
        }
    }
}