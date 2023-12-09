package de.codecentric.springboot.app.web

import de.codecentric.springboot.domain.API
import de.codecentric.springboot.domain.Age
import de.codecentric.springboot.domain.Customer
import de.codecentric.springboot.domain.Id
import de.codecentric.springboot.domain.Name
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class CustomerController(val api: API) {

    @GetMapping("/customer")
    fun getAllCustomer(): List<CustomerDTO> {
        return api.allCustomers().map { CustomerDTO.fromDomain(it) }
    }

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: String): Customer? {
        return api.findCustomer(id)
    }

    @PutMapping("/customer")
    fun storeCustomer(@RequestBody customer: CustomerDTO) {
        api.saveCustomer(customer.toDomain())
    }
}

data class CustomerDTO(val id: String?, val name: String, val age: Long?) {
    companion object
}

private fun CustomerDTO.toDomain(): Customer = Customer(id?.let { Id(it) }, Name(name), age?.let { Age(it) })
private fun CustomerDTO.Companion.fromDomain(customer: Customer) = CustomerDTO(
    customer.id?.value,
    customer.name.value,
    customer.age?.value
)
