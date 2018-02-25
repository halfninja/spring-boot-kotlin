package app

import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider
import org.springframework.core.env.Environment
import org.springframework.core.io.ResourceLoader

/**
 * Lets Spring know if a given view name exists as a KtView template.
 */
class KtTemplateAvailabilityProvider(): TemplateAvailabilityProvider {
    override fun isTemplateAvailable(view: String?, environment: Environment?, classLoader: ClassLoader?, resourceLoader: ResourceLoader?) =
        view?.let { KtViewResolver.viewClass(view) != null } ?: false
}