package com.funck.mscourse.hruser.resources;

import com.funck.mscourse.hruser.entities.User;
import com.funck.mscourse.hruser.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserResource {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable final Long id) {
        return userRepository.findById(id)
                .map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam final String email) {
        return userRepository.findByEmail(email)
                .map(user -> ResponseEntity.ok(user))
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

}
