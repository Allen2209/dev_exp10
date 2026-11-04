package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.service.AuthService;

class AuthServiceTest {
    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthService();
    }

    @Test
    void signupWithValidDetailsShouldSucceed() {
        assertEquals("Signup successful!",
                authService.signup("Allen", "allen@example.com", "secret123"));
    }

    @Test
    void signupWithExistingEmailShouldFail() {
        authService.signup("Allen", "allen@example.com", "secret123");
        assertEquals("Email already registered!",
                authService.signup("Another User", "allen@example.com", "password123"));
    }

    @Test
    void loginWithCorrectCredentialsShouldSucceed() {
        authService.signup("Allen", "allen@example.com", "secret123");
        assertEquals("Login successful! Welcome, Allen.",
                authService.login("allen@example.com", "secret123"));
    }

    @Test
    void loginWithWrongPasswordShouldFail() {
        authService.signup("Allen", "allen@example.com", "secret123");
        assertEquals("Invalid email or password.",
                authService.login("allen@example.com", "wrongpass"));
    }

    @Test
    void signupWithShortPasswordShouldFail() {
        assertEquals("Please enter a name, valid email and password (minimum 6 characters).",
                authService.signup("Allen", "allen@example.com", "123"));
    }
}
