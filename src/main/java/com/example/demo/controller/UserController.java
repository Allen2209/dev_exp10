package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.AuthRequest;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/api")
public class UserController {
    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signup(@RequestBody AuthRequest request) {
        String result = authService.signup(request.getName(), request.getEmail(), request.getPassword());
        boolean success = result.equals("Signup successful!");
        return ResponseEntity.status(success ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
                .body(Map.of("message", result));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest request) {
        String result = authService.login(request.getEmail(), request.getPassword());
        boolean success = result.startsWith("Login successful!");
        return ResponseEntity.status(success ? HttpStatus.OK : HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", result));
    }
}
