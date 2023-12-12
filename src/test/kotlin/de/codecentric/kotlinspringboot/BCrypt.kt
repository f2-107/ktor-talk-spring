package de.codecentric.kotlinspringboot

import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class BCrypt {

    @Test
    fun bcrypt() {
        println(BCryptPasswordEncoder().encode("pass"))
    }
}
