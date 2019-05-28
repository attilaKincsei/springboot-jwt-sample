package com.example.demo.controller;

import com.example.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;

import java.util.HashMap;
import java.util.Optional;

@RestController()
public class UserinfoController {

    private UserRepository userRepository;

    public UserinfoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // The type of @AuthenticationPrincipal will be the same as the first parameter in
    // UsernamePasswordAuthenticationToken constructor (@see JwtTokenServices)
    @GetMapping("/me")
    public ResponseEntity currentUser(@AuthenticationPrincipal String userDetails){
        Optional<User> user = userRepository.findByUsername(userDetails);
        if (user.isPresent()) {
            User user1 = user.get();
            return ResponseEntity.ok(user1.getUsername() + "\n" + user1.getRoles());
        }
        return ResponseEntity.status(404).body("user not found");
    }
}
