package cps.react.component

import kotlinext.js.jsObject
import kotlinx.html.ThScope
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min
import kotlin.reflect.KMutableProperty1

interface ReactTableState<D> : RState {
    var data: List<D>
    var headerIcon: String
    var currentpage: Int


}

interface ReactTableProps<D> : RProps {
    var data: List<D>
    var numberedRows: Boolean
    var classes: String
    var tbodyClasses: String?
    var reactTableHeader: ReactTableHeader<D>
    var defRow: ReactTableRow<D>
    var pagination: Boolean
    var paginationSize: Int
    // var checkBoxes:Boolean


}

enum class PageButtonType {
    PREV,
    NUMBER,
    NEXT

}

/**
 *  @author Juan Otero
 *  react component for datatable
 *
 */

class ReactTable<D> : RComponent<ReactTableProps<D>, ReactTableState<D>>() {


    var currentOrderItem: HTMLElement? = null
    var numberOfPage: Int = 0
    var currLI: HTMLElement? = null


    override fun ReactTableState<D>.init() {
        console.info("data primer override")
        headerIcon = "fas fa-arrows-alt-v"
        currentpage = 0


    }

    override fun ReactTableState<D>.init(props: ReactTableProps<D>) {

        console.info("data props ${props.data}")
        this.data = props.data
    }


    /*override fun componentWillReceiveProps(nextProps: ReactTableProps<D>) {
        console.info("next props override")

        super.componentWillReceiveProps(nextProps)
    }*/


    override fun RBuilder.render() {

        console.info("from render ${props.reactTableHeader}")
        //if (state.data == undefined || props.data.size>0) {
            state.data = props.data

       // }
        console.info("data init ${state.data}")
        console.log(" page value ${state.currentpage}")
        table(classes = "table table-sm table-striped table-bordered") {
            thead(classes = "thead-dark") {

                tr(classes = props.reactTableHeader.classes) {
                    if (props.numberedRows) {
                        th(ThScope.col) {
                            +"#"
                        }
                    }
                    props.reactTableHeader.reactTableHeaderColumns?.let {
                        console.warn(it)
                        it.forEach { hc ->
                            th(ThScope.col) {
                                div(classes = "nav") {
                                    span { +"${hc.text}" }
                                    if (hc.hasOrder()) {
                                        a {
                                            i(classes = "fas fa-arrows-alt-v") {

                                            }
                                            attrs.onClickFunction = { ev ->

                                                var item: HTMLElement = ev.target as HTMLElement

                                                item.className = if (hc.toggleUp) {
                                                    "fas fa-long-arrow-alt-down"
                                                } else {
                                                    "fas fa-long-arrow-alt-up"
                                                }

                                                currentOrderItem?.let { coi ->
                                                    if (coi != item) {

                                                        coi.className = "fas fa-arrows-alt-v"
                                                        currentOrderItem = item
                                                    }
                                                }.run {
                                                    currentOrderItem = item
                                                }

                                                console.warn("toggle order")
                                                state.data = hc.toggleOrderBy(state.data)
                                                setState()
                                                {
                                                    state.data
                                                    //state.headerIcon
                                                }
                                            }
                                        }
                                    }
                                }

                            }

                        }
                    }

                    /* if(props.checkBoxes) {
                         th(ThScope.col) {
                             +""
                         }
                     }*/

                }
            }
            //table boddy
            tbody(classes = props.tbodyClasses) {
                // console.info("data ${state.data}")
                val maxValue = (state.currentpage + 1) * props.paginationSize
                console.info("max value > ${maxValue}")
                console.info(" pagination? > ${props.pagination}")

                var paginatedData = if (props.pagination) state.data.subList(
                    min(
                        state.currentpage * props.paginationSize,
                        state.data.size - props.paginationSize + 1
                    ), min(maxValue, state.data.size)
                ) else state.data

                console.info("pgdata  ${JSON.stringify(paginatedData)}")

                paginatedData.forEachIndexed { index, dt ->
                    tr {

                        // console.info("data $dt")
                        if (props.numberedRows) {
                            th(scope = ThScope.row) {
                                +"${index + 1}"
                            }
                        }

                        props.defRow.reactTableColumns?.let {
                            it.forEach { col ->
                                td {
                                    col.getPropStringValue(dt)?.let { st ->
                                        +st
                                    }
                                    col.renderColumn(dt)?.let { rd ->
                                        this.child(rd)
                                    }
                                }

                            }
                        }

                        /* if(props.checkBoxes) {
                             td(classes = "td-actions") {
                                 input(type = InputType.checkBox) {
                                     attrs.id = "tableCheckBoxRow$index"
                                 }
                             }
                         }*/


                    }
                }
            }
            tfoot {

            }
        }

        //pagination

        var numberOfPage = ceil((state.data.size / props.paginationSize.toDouble())).toInt()
        console.log("number of page, $numberOfPage")
        if (props.pagination && numberOfPage > 1) {
            nav {
                attrs["aria-label"] = "Page navigation example"
                ul(classes = "pagination justify-content-end") {
                    li(classes = "page-item") {
                        a(classes = "page-link") {
                            attrs["aria-label"] = "Previous"
                            span {
                                attrs["aria-hidden"] = "true"
                                +"<<"
                            }
                            attrs.onClickFunction = { ev ->

                                onChangePageEvent(ev, max(0, state.currentpage - 1), PageButtonType.PREV)

                                /* var tg = ev.target as HTMLElement
                                  val liPar= tg.parentElement as HTMLElement

                                  console.info("lipar = ${liPar.classList}")
                                  state.currentpage= max(0,state.currentpage-1)
                                   if(state.currentpage==0)
                                  {
                                      liPar.classList.add("disabled")
                                  }
                                  setState()
                                  {
                                      state.currentpage
                                  }*/

                            }

                        }
                    }
                    for (index in 1..numberOfPage) {
                        li(
                            classes = "page-item${if (index == 1) " active" else {
                                ""
                            }}"
                        ) {

                            a(classes = "page-link") {


                                +"$index"
                                attrs.onClickFunction = { ev ->
                                    //state.currentpage=index-1
                                    onChangePageEvent(ev, index - 1, PageButtonType.NUMBER)

//                                    setState()
//                                    {
//                                        state.currentpage
//                                    }
//                                   console.log(" page value $index")
                                }
                            }
                        }
                    }

                    li(classes = "page-item") {
                        a(classes = "page-link") {

                            attrs["aria-label"] = "Next"
                            span {
                                attrs["aria-hidden"] = "true"
                                +">>"
                            }
                            attrs.onClickFunction = { ev ->
                                onChangePageEvent(
                                    ev,
                                    min(state.currentpage + 1, props.data.size - 1),
                                    PageButtonType.NEXT
                                )


                            }
                        }
                    }
                }
            }
        }
    }

    private fun onChangePageEvent(ev: Event, page: Int, buttonType: PageButtonType) {
        state.currentpage = page

        setState()
        {
            state.currentpage
        }
        console.log(" page value ${state.currentpage}")
    }

}

/**
 * builder functio to render
 */
inline fun <reified D> RBuilder.reactTable(
    data: List<D>,
    classes: String = "table",
    tbodyClasses: String? = null,
    reactTableHeader: ReactTableHeader<D> = ReactTableHeader(),
    defRow: ReactTableRow<D>,
    numberedRows: Boolean = false,
    pagination: Boolean = false,
    paginationSize: Int = 12
) = child(ReactTable<D>()::class)
{
    attrs {
        this.data = data
        this.reactTableHeader = reactTableHeader
        this.classes = classes
        this.tbodyClasses = tbodyClasses
        this.numberedRows = numberedRows
        this.defRow = defRow
        this.pagination = pagination
        this.paginationSize = paginationSize
    }
}


fun <P : RProps, S : RState> RBuilder.child(component: RComponent<P, S>, handler: RHandler<P>): ReactElement {
    val props: P = jsObject {}
    return child(component, props, handler)
}


/**
 * @author Juan Otero
 * Stores header information
 */
data class ReactTableHeader<D>(
    var classes: String? = null,
    val reactTableHeaderColumns: List<ReactTableHeaderColumn<D>>? = null
)

/**
 * @author Juan Otero
 * helper class to manage header columns
 */
class ReactTableHeaderColumn<D>(
    var classes: String? = null,
    var text: String = "",
    val orderColumn: ((D) -> Comparable<*>?)? = null,
    var currentOrderColumn: Boolean = false
) {

    var toggleUp = true
    fun toggleOrderBy(data: List<D>): List<D> {


        var sort: List<D>? = null
        orderColumn?.let {
            console.info("order")
            if (toggleUp) {
                sort = data.sortedWith(

                    compareByDescending(it)

                )
            } else {
                sort = data.sortedWith(

                    compareBy(it)
                )
            }
            toggleUp = !toggleUp

        }
        console.info("sort ${sort}")
        return sort.orEmpty()

    }

    fun hasOrder(): Boolean {
        return orderColumn != null

    }


}

/**
 *  @author Juan Otero
 * table row
 */
class ReactTableRow<D>(var classes: String? = null, var reactTableColumns: List<ReactTableColumn<D>>? = emptyList())


/**
 *  @author Juan Otero
 * table column
 */
class ReactTableColumn<D>(
    var classes: String? = null,
    val prop: KMutableProperty1<D, *>? = null,
    var render: ((D) -> ReactElement)? = null
) {

    //abstract fun getPropStringValue(obj:D/*,  prop: KMutableProperty<D>*/): String
    fun getPropStringValue(obj: D): String? {

        return if (prop != null) {
            //console.log("prop ${obj.asDynamic()[prop.name]}")
            "${obj.asDynamic()[prop.name]}"
        } else
            null
    }


    fun renderColumn(elem: D): ReactElement? {

        var el = render?.invoke(elem)
        // console.log("render element ${el?.asStringOrNull()}")
        return el

    }

}


