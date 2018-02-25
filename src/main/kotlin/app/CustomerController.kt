package app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(private val repository: CustomerRepository) {

	@GetMapping("/customers")
	fun findAll() = repository.findAll()

	@GetMapping("/customers/{name}")
	fun findByLastName(@PathVariable name:String)
			= repository.findByName(name)
}