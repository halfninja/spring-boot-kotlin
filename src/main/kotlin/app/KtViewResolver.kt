package app

import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import org.springframework.util.Assert
import org.springframework.web.servlet.View
import org.springframework.web.servlet.ViewResolver
import java.util.*

/**
 * Resolves views as objects under the `views` package, e.g.
 * `error/404` resolves to the object `views.error.404` which needs
 * to implement `View`.
 */
class KtViewResolver(val factory: AutowireCapableBeanFactory): ViewResolver {
    override fun resolveViewName(viewName: String, locale: Locale) =
        viewClass(viewName)?.let { factory.createBean(it) }

    companion object {
        private val classPrefix = "views."

        fun viewClass(viewName: String): Class<out View>? {
            try {
                val viewClass = viewName.replace('/', '.')
                val clazz = Class.forName("${classPrefix}$viewClass")
                Assert.isAssignable(View::class.java, clazz)
                return clazz as Class<out View>?
            } catch (e: ClassNotFoundException) {
                return null
            }
        }
    }
}