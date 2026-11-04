package com.example.demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class AuthService {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String signup(String name, String email, String password) {
        if (name == null || name.isBlank() || email == null || email.isBlank()
                || password == null || password.length() < 6) {
            return "Please enter a name, valid email and password (minimum 6 characters).";
        }

        String key = email.trim().toLowerCase();
        if (users.containsKey(key)) {
            return "Email already registered!";
        }

        users.put(key, new User(name.trim(), key, passwordEncoder.encode(password)));
        return "Signup successful!";
    }

    public String login(String email, String password) {
        if (email == null || password == null) {
            return "Invalid email or password.";
        }

        User user = users.get(email.trim().toLowerCase());
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return "Login successful! Welcome, " + user.getName() + ".";
        }
        return "Invalid email or password.";
    }

    public int getUserCount() {
        return users.size();
    }
}
