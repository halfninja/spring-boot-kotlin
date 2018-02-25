package app

import kotlinx.html.*
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.io.Writer

@ControllerAdvice
class ExceptionHandlers {

    @ExceptionHandler
    fun err(exception: Exception, writer: Writer) =
            views.layout.render(writer, "Error") {
                h1(classes = "title is-1") { +"Error" }
                exception.message?.let { p { +it } }
            }

}