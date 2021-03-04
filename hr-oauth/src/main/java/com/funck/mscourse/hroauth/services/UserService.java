package com.funck.mscourse.hroauth.services;

import com.funck.mscourse.hroauth.clients.UserFeignClient;
import com.funck.mscourse.hroauth.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Primary
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final Optional<User> user = userFeignClient.findByEmail(userName);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Email inválido");
        }

        return user.get();
    }
}
