package views.error

import kotlinx.html.*
import app.KtView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

object `404` : KtView() {
    override fun render(model: MutableMap<String, *>?, request: HttpServletRequest, response: HttpServletResponse) {
        val error: String by model
        views.layout.render(response.writer, title = error) {
            h1(classes = "title is-1") { +error }
            p { +"Aw heck" }
        }
    }
}