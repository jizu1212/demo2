package com.example.demo.graphql

import com.example.demo.model.Item
import com.example.demo.service.ItemService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class ItemResolver(private val service: ItemService) {

    @QueryMapping
    fun find(@Argument key: String): Item? {
        return service.find(key)
    }

    @MutationMapping
    fun store(@Argument key: String, @Argument value: String?): Item? {
        return service.store(key, value)
    }
}
