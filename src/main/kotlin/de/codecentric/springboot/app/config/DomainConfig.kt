package de.codecentric.springboot.app.config

import de.codecentric.springboot.domain.API
import de.codecentric.springboot.domain.CustomerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DomainConfig {

    @Bean
    fun api(customerRepository: CustomerRepository) = API(customerRepository)
}
