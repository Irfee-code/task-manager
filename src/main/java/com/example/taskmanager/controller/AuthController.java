package com.example.taskmanager.controller;

import com.example.taskmanager.dto.*;
import com.example.taskmanager.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            authService.register(request);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(
                    "REGISTER ERROR: " + e.getClass().getName() + " - " + e.getMessage()
            );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            return ResponseEntity.ok(authService.login(request));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(
                    "LOGIN ERROR: " + e.getClass().getName() + " - " + e.getMessage()
            );
        }
    }
}