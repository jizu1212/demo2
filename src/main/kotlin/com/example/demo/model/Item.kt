package com.example.demo.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Item(
    @Id
    @Column(name = "item_key")
    val key: String = "",
    @Column(name = "item_value")
    val value: String? = null,
    val createdAt: Long = 0,
    val updatedAt: Long = 0
)
