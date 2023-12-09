package de.codecentric.springboot.domain

class API(val customerRepository: CustomerRepository) {

    private val saveCustomerUseCase = SaveCustomer(customerRepository)
    private val findCustomerUseCase = FindCustomer(customerRepository)
    private val allCustomersUseCase = AllCustomers(customerRepository)

    fun saveCustomer(customer: Customer) = saveCustomerUseCase(customer)
    fun findCustomer(id: String) = findCustomerUseCase(id)
    fun allCustomers() = allCustomersUseCase()
}
