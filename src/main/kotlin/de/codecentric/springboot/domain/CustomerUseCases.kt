package de.codecentric.springboot.domain

import java.util.*

class FindCustomer(val customerRepository: CustomerRepository) {
    operator fun invoke(id: String): Customer? {
        val result = customerRepository.findById(id)
        if (result.isPresent) {
            val customerDao = result.get()
            return Customer(Id(customerDao.id), Name(customerDao.name), Age(customerDao.age))
        }
        return null
    }
}

class SaveCustomer(val customerRepository: CustomerRepository) {
    operator fun invoke(customer: Customer) {
        val customerToSave = when (customer.id) {
            null -> customer.copy(id = Id(UUID.randomUUID().toString()))
            else -> customer
        }

        customerRepository.save(
            CustomerDAO(
                customerToSave.id.value,
                customerToSave.name.value,
                customerToSave.age?.value ?: 0L
            )
        )
    }
}

class AllCustomers(val customerRepository: CustomerRepository) {

    operator fun invoke(): List<Customer> {
        val foundCustomerDaos = customerRepository.findAll().toList()

        if (foundCustomerDaos.isNotEmpty()) {
            return foundCustomerDaos.map { Customer(Id(it.id), Name(it.name), Age(it.age)) }
        }

        return emptyList()
    }
}
