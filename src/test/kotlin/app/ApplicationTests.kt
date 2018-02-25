package app

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.*
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
class ApplicationTests(@Autowired private val restTemplate: TestRestTemplate) {

	@Test
	fun findAll() {
		val content = """[{"firstName":"Simon","lastName":"DeHavilland","id":1},{"firstName":"Chloe","lastName":"Palmer","id":2},{"firstName":"Kim","lastName":"Bauer","id":3},{"firstName":"Paul","lastName":"Simon","id":4},{"firstName":"Michelle","lastName":"Degaussie","id":5}]"""
		assertEquals(content, restTemplate.getForObject<String>("/customers"))
	}

}
