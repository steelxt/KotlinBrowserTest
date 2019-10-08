package cps.react

import kotlinx.html.HTMLTag
import org.w3c.dom.HTMLElement
import react.RBuilder
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.tag

fun RBuilder.toastContainer() = child(ToastContainerComponent::class) {}



