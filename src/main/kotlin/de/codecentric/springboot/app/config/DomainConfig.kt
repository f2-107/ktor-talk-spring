package de.codecentric.springboot.app.config

import de.codecentric.springboot.domain.API
import de.codecentric.springboot.domain.CustomerRepository
import de.codecentric.springboot.domain.InMemoryCustomerStorage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DomainConfig {

    @Bean
    fun inMemoryCustomerStorage() = InMemoryCustomerStorage()

    @Bean
    fun api(customerRepository: CustomerRepository) = API(inMemoryCustomerStorage())
}
