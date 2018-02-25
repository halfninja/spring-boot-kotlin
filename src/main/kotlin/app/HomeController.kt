package app

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController(private val repository: CustomerRepository) {

    @GetMapping("/")
    @ResponseBody
    fun home() = views.home.render(repository.findAll())

}