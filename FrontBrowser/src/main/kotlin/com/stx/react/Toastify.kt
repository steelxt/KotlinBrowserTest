@file:JsModule("react-toastify")

package cps.react

import react.RClass
import react.RProps




import kotlin.js.*
import react.*

external interface   ToastContent

external interface Position {
    var TOP_LEFT: String /* "top-left" */
    var TOP_RIGHT: String /* "top-right" */
    var TOP_CENTER: String /* "top-center" */
    var BOTTOM_LEFT: String /* "bottom-left" */
    var BOTTOM_RIGHT: String /* "bottom-right" */
    var BOTTOM_CENTER: String /* "bottom-center" */
}
external interface Type {
    var INFO: String /* "info" */
    var SUCCESS: String /* "success" */
    var WARNING: String /* "warning" */
    var ERROR: String /* "error" */
    var DEFAULT: String /* "default" */
}
external interface cssTransitionProps {
    var enter: String
    var exit: String
    var duration: dynamic /* Number | Array<Number> */ get() = definedExternally; set(value) = definedExternally
    var appendPosition: Boolean? get() = definedExternally; set(value) = definedExternally
}
external interface CommonOptions {
    var pauseOnHover: Boolean? get() = definedExternally; set(value) = definedExternally
    var pauseOnFocusLoss: Boolean? get() = definedExternally; set(value) = definedExternally
    var closeOnClick: Boolean? get() = definedExternally; set(value) = definedExternally
    var autoClose: dynamic /* Number | Boolean */ get() = definedExternally; set(value) = definedExternally
    var position: dynamic /* String /* "top-left" */ | String /* "top-right" */ | String /* "top-center" */ | String /* "bottom-left" */ | String /* "bottom-right" */ | String /* "bottom-center" */ */ get() = definedExternally; set(value) = definedExternally
    var closeButton: dynamic /* React.ReactNode | Boolean */ get() = definedExternally; set(value) = definedExternally
    var progressClassName: dynamic /* String | Any? */ get() = definedExternally; set(value) = definedExternally
    var progressStyle: Any? get() = definedExternally; set(value) = definedExternally
    var className: dynamic /* String | Any? */ get() = definedExternally; set(value) = definedExternally
    var bodyClassName: dynamic /* String | Any? */ get() = definedExternally; set(value) = definedExternally
    var hideProgressBar: Boolean? get() = definedExternally; set(value) = definedExternally
    var transition:dynamic? get() = definedExternally; set(value) = definedExternally
    var draggable: Boolean? get() = definedExternally; set(value) = definedExternally
    var draggablePercent: Number? get() = definedExternally; set(value) = definedExternally
}
external interface ToastOptions : CommonOptions {
    var onOpen: (() -> Unit)? get() = definedExternally; set(value) = definedExternally
    var onClose: (() -> Unit)? get() = definedExternally; set(value) = definedExternally
    var type: Type? /* String /* "info" */ | String /* "success" */ | String /* "warning" */ | String /* "error" */ | String /* "default" */ */ get() = definedExternally; set(value) = definedExternally
    var toastId: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var progress: Number? get() = definedExternally; set(value) = definedExternally
    var delay: Number? get() = definedExternally; set(value) = definedExternally
}
external interface UpdateOptions : ToastOptions {
    var render: dynamic
}
 external interface ToastContainerProps : RProps {
    var newestOnTop: Boolean
    var style: Any
    var toastClassName: dynamic 
    var rtl: Boolean
}
external interface Toast {
    fun success(content: dynamic, options: ToastOptions? = definedExternally /* null */): dynamic /* String | Number */
    fun info(content: dynamic, options: ToastOptions? = definedExternally /* null */): dynamic /* String | Number */
    fun warn(content: dynamic, options: ToastOptions? = definedExternally /* null */): dynamic /* String | Number */
    fun error(content: dynamic, options: ToastOptions? = definedExternally /* null */): dynamic /* String | Number */
    fun isActive(toastId: String): Boolean
    fun isActive(toastId: Number): Boolean
    fun dismiss(toastId: String? = definedExternally /* null */)
    fun dismiss(toastId: Number? = definedExternally /* null */)
    fun update(toastId: String, options: UpdateOptions? = definedExternally /* null */)
    fun update(toastId: Number, options: UpdateOptions? = definedExternally /* null */)
    fun onChange(callback: (count: Number? /*= null*/) -> Unit)
    fun done(toastId: String, progress: Number? = definedExternally /* null */)
    fun done(toastId: Number, progress: Number? = definedExternally /* null */)
    fun configure(config: ToastContainerProps? = definedExternally /* null */)
    @nativeInvoke
    operator fun invoke(content: dynamic, options: ToastOptions? = definedExternally /* null */): dynamic /* String | Number */
    var TYPE: Type
    var POSITION: Position
    fun dismiss()
}




@JsName("toast")
external val toast:Toast
external  val Slide:RComponent<RProps,RState>
external val ToastType: Type

//@JsName("ToastContainer")
//external val toastContainer:RClass<ToastContainerProps>
@JsName("ToastContainer")
external class ToastContainerComponent : Component<ToastContainerProps, RState> {
     override fun render():ReactElement?

}



