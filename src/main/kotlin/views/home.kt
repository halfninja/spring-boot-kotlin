package views

import app.Customer
import app.KtView
import kotlinx.html.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

object home : KtView() {
    // View compatibility
    override fun render(model: Map<String, *>?, request: HttpServletRequest, response: HttpServletResponse) {
        val customers: Iterable<Customer> by model
        render(customers)
    }

    fun render(customers: Iterable<Customer>) = layout.render(title="Home") {
        h1(classes = "title is-1") { +"Customer data" }
        p {
            customers.map {
                div { +"${it.firstName} ${it.lastName}" }
            }
        }
    }
}