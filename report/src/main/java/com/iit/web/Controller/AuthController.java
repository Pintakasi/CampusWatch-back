package com.iit.web.Controller;

import com.iit.web.Dto.LoginRequestDto;
import com.iit.web.Model.User;
import com.iit.web.Repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("auth")
@RestController
public class AuthController
{
    @Autowired
    private UserRepo userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request, HttpSession session) {
        User user = userRepository.findByEmail(request.email());

        if (user == null || !user.getPassword().equals(request.password())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        // Store user in session
        session.setAttribute("userId", user.getId());
        session.setAttribute("role", user.getRole());

        System.out.println("Session ID: " + session.getId());

        return ResponseEntity.ok(Map.of(
                "role", user.getRole(),
                "userId", user.getId()
        ));
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out");
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(HttpSession session) {
        String role = (String) session.getAttribute("role");
        var userId = session.getAttribute("userId");

        if (role == null || userId == null) {
            return ResponseEntity.status(401).body("Not logged in");
        }

        return ResponseEntity.ok(Map.of(
                "role", role,
                "userId", userId
        ));
    }

}
