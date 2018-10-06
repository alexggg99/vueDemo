package com.agashchuk.vueDemo.controller

import com.agashchuk.vueDemo.exception.NotFoundException
import org.springframework.web.bind.annotation.*

import java.util.ArrayList
import java.util.HashMap
import java.util.function.Supplier

@RestController
@RequestMapping("message")
class MessageController {
    private var counter = 4

    private val messages = object : ArrayList<Map<String, String>>() {
        init {
            add(object : HashMap<String, String>() {
                init {
                    put("id", "1")
                    put("text", "First message")
                }
            })
            add(object : HashMap<String, String>() {
                init {
                    put("id", "2")
                    put("text", "Second message")
                }
            })
            add(object : HashMap<String, String>() {
                init {
                    put("id", "3")
                    put("text", "Third message")
                }
            })
        }
    }

    @GetMapping
    fun list(): List<Map<String, String>> = messages

    @GetMapping("{id}")
    fun getOne(@PathVariable id: String) = getMessage(id)

    private fun getMessage(@PathVariable id: String): Map<String, String> {
        return messages.stream()
                .filter { message -> message["id"] == id }
                .findFirst()
                .orElseThrow<NotFoundException>(Supplier<NotFoundException> { NotFoundException() })
    }

    @PostMapping
    fun create(@RequestBody message: MutableMap<String, String>): Map<String, String> {
        message["id"] = counter++.toString()

        messages.add(message)

        return message
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: String, @RequestBody messag: String): Map<String, String> {
        val messageFromDb = getMessage(id)

        return messageFromDb
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: String) {
        val message = getMessage(id)

        messages.remove(message)
    }
}
