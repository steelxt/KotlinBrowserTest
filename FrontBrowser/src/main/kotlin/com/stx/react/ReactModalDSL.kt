package cps.react

import org.w3c.dom.events.Event
import react.RBuilder
import react.RHandler


fun RBuilder.reactModal(isOpen: Boolean = false,onRequestClose: ((event: Event ) -> Unit)? =null, handler: RHandler<ReactModal.Props>) = child(ReactModal::class) {
    attrs.isOpen=isOpen
    attrs.shouldCloseOnEsc=true
    onRequestClose?.let {
        attrs.onRequestClose=it
    }

    handler()
}