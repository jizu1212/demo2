package com.example.demo.service

import com.example.demo.model.Item
import com.example.demo.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(private val repo: ItemRepository) {

    fun find(key: String): Item? {
        val result = repo.findById(key)
        return if (result.isPresent) result.get() else null
    }


    fun store(key: String, value: String?): Item? {
        val old = repo.findById(key).orElse(null)?.copy() //
        val now = System.currentTimeMillis() / 1000

        val new = Item(key, value, old?.createdAt ?: now, now)
        repo.save(new)
        return old
    }
}
