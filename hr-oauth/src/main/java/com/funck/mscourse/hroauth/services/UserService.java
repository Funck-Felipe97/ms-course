package com.funck.mscourse.hroauth.services;

import com.funck.mscourse.hroauth.clients.UserFeignClient;
import com.funck.mscourse.hroauth.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserFeignClient userFeignClient;

    public Optional<User> findByEmail(final String email) {
        return userFeignClient.findByEmail(email);
    }

}
