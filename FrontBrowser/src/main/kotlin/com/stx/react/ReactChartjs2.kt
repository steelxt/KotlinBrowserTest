@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION")
@file:JsModule("react-chartjs-2")

package cps.react


import kotlin.js.*
import org.w3c.dom.*
import react.Component
import react.RProps
import react.ReactElement

external interface ChartComponentProps: RProps {
    var data: dynamic /* ChartDataFunction<chartjs.ChartData> | chartjs.ChartData */
    var type: dynamic  //Chart.ChartType? get() = definedExternally; set(value) = definedExternally
    val getDatasetAtEvent: ((e: Any) -> Unit)? get() = definedExternally
    val getElementAtEvent: ((e: Any) -> Unit)? get() = definedExternally
    val getElementsAtEvent: ((e: Any) -> Unit)? get() = definedExternally
    var height: Number? get() = definedExternally; set(value) = definedExternally
    var legend: Chart.ChartLegendOptions? get() = definedExternally; set(value) = definedExternally
    val onElementsClick: ((e: Any) -> Unit)? get() = definedExternally
    var options: Chart.ChartOptions? get() = definedExternally; set(value) = definedExternally
    var plugins: Array<Any?>? get() = definedExternally; set(value) = definedExternally
    var redraw: Boolean? get() = definedExternally; set(value) = definedExternally
    var width: Number? get() = definedExternally; set(value) = definedExternally
    var datasetKeyProvider: ((any: Any) -> Any)? get() = definedExternally; set(value) = definedExternally
}
external interface LinearComponentProps : ChartComponentProps {
    override var data: dynamic /* ChartDataFunction<chartjs.ChartData> | chartjs.ChartData */
}
@JsName("default")
external open class ChartComponent< P : ChartComponentProps> : Component<  P, dynamic> {
    open var chartInstance: dynamic
    override fun render(): ReactElement?
}


@JsName("Doughnut")
external  class Doughnut : ChartComponent<ChartComponentProps>
external  class Pie : ChartComponent<ChartComponentProps>
external  class Line : ChartComponent<LinearComponentProps>
external  class Scatter : ChartComponent<ChartComponentProps>
external  class Bar : ChartComponent<LinearComponentProps>
external  class HorizontalBar : ChartComponent<ChartComponentProps>
external  class Radar : ChartComponent<ChartComponentProps>
external  class Polar : ChartComponent<ChartComponentProps>
external  class Bubble : ChartComponent<ChartComponentProps>
external object defaults {
}
