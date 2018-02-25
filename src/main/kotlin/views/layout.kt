package views

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import kotlinx.html.dom.*
import java.io.StringWriter

object layout {

    const val HTML5_DOCTYPE = "<!doctype html>"

    fun render(writer: Appendable, title: String, content: DIV.() -> Unit) {
        writer.appendln(HTML5_DOCTYPE)
        writer.appendHTML().html {
            head {
                title(title)
                meta(name = "viewport", content = "width=device-width, initial-scale=1")
                link(rel = "stylesheet", href = "https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css")
            }
            body {
                nav(classes="navbar") {
                    div(classes="navbar-brand") {
                        a(classes="navbar-item has-text-weight-bold", href="/") {
                            +"Fantastic App"
                        }
                        div(classes="navbar-item has-dropdown is-hoverable") {
                            a(classes="navbar-link") { +"API" }
                            div(classes="navbar-dropdown is-boxed") {
                                a(classes="navbar-item", href="/customers") { +"Customers" }
                                a(classes="navbar-item", href="/customers/Simon") { +"Customers by name" }
                            }
                        }
                    }
                }
                section(classes = "section") {
                    div(classes = "container") {
                        content()
                    }
                }
            }
        }
    }

    fun render(title: String, content: DIV.() -> Unit): String =
            with(StringWriter()) {
                render(this, title, content)
                this.toString()
            }

}