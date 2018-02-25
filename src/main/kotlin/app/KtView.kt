package app

import org.springframework.web.servlet.View

/**
 * You can use your Kotlin HTML views directly from a controller and get type checking,
 * but if you need to resolve through the View system for some reason (like to use it
 * as an error page) you can implement this, delegating parameters to the model map.
 *
 * This view doesn't really have anything in particular to do with Kotlin views, it just
 * implements contentType.
 */
abstract class KtView(
        val mimeType: String = "text/html",
        val encoding: String = "UTF-8"
) : View {
    override fun getContentType() = "$mimeType;charset=$encoding"
}