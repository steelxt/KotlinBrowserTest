@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION")
//@file:JsModule("react-modal")

package cps.react

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
import react.Component
import react.RProps
import react.RState
import react.ReactElement

//@JsName("ReactModal")
@JsModule("react-modal")
external open class ReactModal : Component<ReactModal.Props,RState> {
    override fun render(): ReactElement?

    interface Styles {
        var content: Json? get() = definedExternally; set(value) = definedExternally
        var overlay: Json? get() = definedExternally; set(value) = definedExternally
    }
    interface Classes {
        var base: String
        var afterOpen: String
        var beforeClose: String
    }
    interface Aria {
        var labelledby: String? get() = definedExternally; set(value) = definedExternally
        var describedby: String? get() = definedExternally; set(value) = definedExternally
        var modal: dynamic /* Boolean | 'false' | 'true' */
    }
    interface Props: RProps {
        var isOpen: Boolean
        var style: Styles? get() = definedExternally; set(value) = definedExternally
        var portalClassName: String? get() = definedExternally; set(value) = definedExternally
        var bodyOpenClassName: String? get() = definedExternally; set(value) = definedExternally
        var htmlOpenClassName: String? get() = definedExternally; set(value) = definedExternally
        var className: dynamic /* String | Classes */
        var overlayClassName: dynamic /* String | Classes */
        var appElement: dynamic /* HTMLElement | Any */
        val onAfterOpen: (() -> Unit)? get() = definedExternally
        val onAfterClose: (() -> Unit)? get() = definedExternally
        var onRequestClose: ((event: Event /* React.MouseEvent | React.KeyboardEvent */) -> Unit)? get() = definedExternally;set(value) = definedExternally
        var closeTimeoutMS: Number? get() = definedExternally; set(value) = definedExternally
        var ariaHideApp: Boolean? get() = definedExternally; set(value) = definedExternally
        var shouldFocusAfterRender: Boolean? get() = definedExternally; set(value) = definedExternally
        var shouldCloseOnOverlayClick: Boolean? get() = definedExternally; set(value) = definedExternally
        var shouldCloseOnEsc: Boolean? get() = definedExternally; set(value) = definedExternally
        var shouldReturnFocusAfterClose: Boolean? get() = definedExternally; set(value) = definedExternally
        val parentSelector: (() -> HTMLElement)? get() = definedExternally
        var aria: Aria? get() = definedExternally; set(value) = definedExternally
        var data: Any? get() = definedExternally; set(value) = definedExternally
        var role: String? get() = definedExternally; set(value) = definedExternally
        var contentLabel: String? get() = definedExternally; set(value) = definedExternally
        var contentRef: ((instance: HTMLDivElement) -> Unit)? get() = definedExternally; set(value) = definedExternally
        var overlayRef: ((instance: HTMLDivElement) -> Unit)? get() = definedExternally; set(value) = definedExternally
        var testId: String? get() = definedExternally; set(value) = definedExternally
    }
    companion object {
        var defaultStyles: ReactModal.Styles
        fun setAppElement(appElement: String)
        fun setAppElement(appElement: HTMLElement)
    }
}