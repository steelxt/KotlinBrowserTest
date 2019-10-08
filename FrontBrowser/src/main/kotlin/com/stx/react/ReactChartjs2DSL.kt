package cps.react

import org.w3c.dom.HTMLElement
import org.w3c.dom.events.MouseEvent
import react.RBuilder

fun RBuilder.doughnut(
    data: Chart.ChartData,
    width: Number? = null,
    height: Number? = null,
    options: Chart.ChartOptions? = null
) = child(
    Doughnut::class
) {


    attrs {

        this.data = data
        width?.let {
            console.info("width = $it")
            this.width = it
        }
        height?.let {
            console.info("height = $it")
            this.height = it
        }

        options?.let {
            this.options = options

        }
    }
}

fun RBuilder.pie(
    data: Chart.ChartData,
    width: Number? = null,
    height: Number? = null,
    options: Chart.ChartOptions? = null
) = child(
    Pie::class
) {


    attrs {

        this.data = data
        width?.let {
            console.info("width = $it")
            this.width = it
        }
        height?.let {
            console.info("height = $it")
            this.height = it
        }

        options?.let {
            this.options = options

        }
    }
}


inline fun ChartData(labels: Array<String /* String | Array<String> */>?, datasets: Array<Chart.ChartDataSets>?) =
    object : Chart.ChartData {}.apply {
        this.labels = labels
        this.datasets = datasets
    }

inline fun ChartOptions(
    responsive: Boolean? = undefined,
    responsiveAnimationDuration: Number? = undefined,
    aspectRatio: Number? = undefined,
    maintainAspectRatio: Boolean? = undefined,
    events: Array<String>? = undefined,
   legendCallback: ((chart: Chart) -> String),
   /*  onHover: ((`this`: Chart, event: MouseEvent, activeElements: Array<Any>) -> Any),
    onClick: ((event: MouseEvent? /*= null*/, activeElements: Array<Any>? /*= null*/) -> Any),
    onResize: ((`this`: Chart, newSize: Chart.ChartSize) -> Unit),*/
    title: Chart.ChartTitleOptions? = undefined,
    legend: Chart.ChartLegendOptions? = undefined,
    tooltips: Chart.ChartTooltipOptions? = undefined,
    hover: Chart.ChartHoverOptions? = undefined,
    animation: Chart.ChartAnimationOptions? = undefined,
    elements: Chart.ChartElementsOptions? = undefined,
    layout: Chart.ChartLayoutOptions? = undefined,
    scales: Chart.ChartScales? = undefined,
    showLines: Boolean? = undefined,
    spanGaps: Boolean? = undefined,
    cutoutPercentage: Number? = undefined,
    circumference: Number? = undefined,
    rotation: Number? = undefined,
    devicePixelRatio: Number? = undefined,
    plugins: Chart.ChartPluginsOptions? = undefined

) = object : Chart.ChartOptions {}.apply {

    this.responsive = responsive
    this.responsiveAnimationDuration = responsiveAnimationDuration
    this.aspectRatio = aspectRatio
    this.maintainAspectRatio = maintainAspectRatio
    this.events = events

    this.title= title
    this.legend = legend
    this.tooltips=tooltips
    this. hover= hover
    this. animation=animation
    this. elements=elements
    this. layout=layout
    this. scales=scales
    this. showLines= showLines
    this. spanGaps =spanGaps
    this. cutoutPercentage = cutoutPercentage
    this. circumference= circumference
    this.rotation = rotation
    this. devicePixelRatio = devicePixelRatio
    this. plugins= plugins

}

typealias ChartDataFunction<T> = (element: HTMLElement) -> T
