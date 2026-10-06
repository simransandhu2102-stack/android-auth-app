package com.practice.createandlogin

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LoginTests {
    @Test
    fun test_empty_email() {
        val email = validateEmail("")
        assertFalse(email)
    }

    @Test
    fun test_valid_email() {
        val email = validateEmail("email@xyz.com")
        assertTrue(email)
    }

    @Test
    fun test_invalid_email(){
        val email = validateEmail("xyz.com")
        assertFalse(email)
    }

    @Test
    fun test_empty_password(){
        val password = validatePassword("")
        assertFalse(password)
    }

    @Test
    fun test_valid_password(){
        val password = validatePassword("password")
        assertTrue(password)
    }

    @Test
    fun test_invalid_password(){
        val password = validatePassword("pass")
        assertFalse(password)
    }
}