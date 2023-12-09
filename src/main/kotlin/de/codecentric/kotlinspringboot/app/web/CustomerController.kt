package de.codecentric.kotlinspringboot.app.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class CustomerController {

    @GetMapping("/")
    fun helloWorld(): String {
        return "Hello Spring-World!"
    }
}
