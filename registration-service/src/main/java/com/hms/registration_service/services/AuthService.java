package com.hms.registration_service.services;

import com.hms.registration_service.dto.LoginRequest;
import com.hms.registration_service.dto.RegisterRequest;
import com.hms.registration_service.entities.User;
import com.hms.registration_service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public String register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return "Username already exists!";
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword()) // You can use BCrypt here if needed
                .role(request.getRole())
                .build();

        userRepository.save(user);
        return "User registered successfully!";
    }

    public String login(LoginRequest request) {
        Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(request.getPassword())) {
                return "Login successful!";
            } else {
                return "Invalid password.";
            }
        } else {
            return "User not found.";
        }
    }
}
