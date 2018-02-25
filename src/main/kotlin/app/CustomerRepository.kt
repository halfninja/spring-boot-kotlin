package app

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface CustomerRepository : CrudRepository<Customer, Long> {

	fun findByLastName(lastName: String): Iterable<Customer>

	fun findByFirstName(firstName: String): Iterable<Customer>

	@Query("from Customer c where c.firstName=:name or c.lastName=:name")
	fun findByName(@Param("name") name: String): Iterable<Customer>
}
