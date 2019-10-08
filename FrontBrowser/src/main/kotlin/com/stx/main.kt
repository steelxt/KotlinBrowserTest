package com.stx




import cps.react.*

import kotlinext.js.require
import kotlinext.js.requireAll
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.events.Event
import react.dom.*
import react.setState
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.json

fun main(args: Array<String>) {
    var requestUserModalIsOpen=true


    //print( rest)

    requireAll(require.context("kotlin", true, js("/\\.css$/")))


    require("react-toastify/dist/ReactToastify.css")


    window.onload = {


        console.info("loaded...")
        val root = document.getElementById("root") ?: throw IllegalStateException()

        ReactModal.setAppElement(root as HTMLElement)
        render(root) {

            //show toast notifications  from this place
            toastContainer()


            reactModal(requestUserModalIsOpen)
            {

                //clean variables


                this.attrs.style = object : ReactModal.Styles {}.apply {
                    content = json (
                        "position" to "relative",
                        "top" to "25%",
                        "left" to "25%",
                        "right" to "auto",
                        "bottom" to "auto",
                        "marginRight" to "50%",
                        //"transform" to "translate(-50%, -50%)"
                        "padding" to "0px",
                        "borderRadius" to "14px"
                        //"inset" to "50% 50% auto 50%"

                    )
                }

                ///  div(classes = "container-fluid") {


                div(classes = "card border-light mb-3") {
                    div(classes = "card-header") {


                        attrs.jsStyle["background-color"] = "#25d366"

                        div(classes = "container-fluid") {


                            div(classes = "row") {
                                div(classes = "col-11") {
                                    p {
                                        strong { +"Buscar movi Usuario" }
                                    }
                                }
                                div(classes = "col-1") {



                                    input(classes = "close", type = InputType.image) {
                                        attrs.jsStyle["margin-right"] = "-30px"
                                        attrs.src = "images/Group 18.svg"
                                        //attrs["data-dismiss"] = "modal"
                                        // attrs["aria-label"] = "Close"

                                        attrs.onClickFunction = {

                                            console.info("click close")

                                                requestUserModalIsOpen = false



                                        }
                                    }
                                }
                            }


                            /* button(classes = "close") {
                             attrs["aria-label"] = "Close"
                             span {
                                 attrs["aria-hidden"] = "true"
                                 +"&times;"
                             }
                         }*/

                        }
                    }
                    div(classes = "card-body") {

                        div(classes = "container") {
                            div(classes = "cantidad") {
                                div (classes = "form-group"){
                                    h4 { +"" }
                                    select (classes = "form-control"){


                                        attrs.value = ""

                                        attrs.onChangeFunction = { ev: Event ->
                                            val target = ev.target as HTMLSelectElement
                                            console.log("select value=${target.value}")

                                        }

                                        option {
                                            +"teléfono"
                                            attrs.value = ""
                                            attrs.selected = true
                                        }
                                        option {
                                            +"cédula"
                                            attrs.value = "username"

                                        }
                                        option {
                                            +"email"
                                            attrs.value = "email"

                                        }

                                    }
                                }

                            }
                            div(classes = "form-group" ) {
                                input(classes = "form-control") {
                                    attrs.type = InputType.text
                                    attrs.name = ""
                                    //attrs.value = "$35.450"
                                    attrs.onChangeFunction = { ev: Event ->
                                        val target = ev.target as HTMLInputElement

                                    }
                                }

                            }


                            div(classes = "modal-footer flex-center") {

                                input(classes = "cobrar btn") {
                                    attrs.type = InputType.button
                                    attrs.name = ""
                                    attrs.value = "Buscar Usuario"
                                    attrs.onClickFunction = {
                                        console.info("click close")


                                    }
                                    this@reactModal.attrs.onRequestClose = {
                                            requestUserModalIsOpen = false


                                        console.info("closed")
                                    }

                                }
                            }
                        }


                    }
                }
                //   }
            }

        }

    }


}
