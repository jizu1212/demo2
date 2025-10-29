package com.example.demo.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class ItemServiceTest(@Autowired val service: ItemService) {
    @BeforeEach
    fun setup() {
    }


    @Test
    @DisplayName("find 실패 시 null 반환")
    fun findFail() {
        val result = service.find("shouldfail")
        assertNull(result)
    }


    @Test
    @DisplayName("find 성공")
    fun findSuccess() {
        service.store("AAA", "BBB")
        val item = service.find("AAA")

        assertNotNull(item)
        assertEquals("BBB", item?.value )
    }

    @Test
    @DisplayName("store 새로운 아이템 추가")
    fun storeNewItem() {
        val old = service.store("TestKey1", "TestValue1")
        val new = service.find("TestKey1")
        assertNull(old)
        assertEquals("TestValue1", new?.value)
    }

    @Test
    @DisplayName("store 기존 아이템 수정")
    fun storeUpdateItem() {
        service.store("sampleKey", "oldValue")
        val item = service.store("sampleKey", "newValue")
        assertNotNull(item)
        assertEquals("oldValue", item?.value)
    }




}
