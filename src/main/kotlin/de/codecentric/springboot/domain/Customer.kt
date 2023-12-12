package de.codecentric.springboot.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne
import org.springframework.data.repository.CrudRepository

@JvmInline
value class Id(val value: String)

@JvmInline
value class Name(val value: String)

@JvmInline
value class Age(val value: Long)

data class Customer(
    val id: Id,
    val name: Name,
    val age: Age?,
)

@Entity
data class CustomerDAO(@jakarta.persistence.Id val id: String, val name: String, val age: Long) {
    constructor() : this("", "", 0)
}

interface CustomerRepository : CrudRepository<CustomerDAO, String>
