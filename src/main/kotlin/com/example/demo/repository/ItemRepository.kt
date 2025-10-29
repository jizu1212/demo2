package com.example.demo.repository

import com.example.demo.model.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, String>
