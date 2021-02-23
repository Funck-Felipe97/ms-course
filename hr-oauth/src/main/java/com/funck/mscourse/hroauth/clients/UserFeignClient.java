package com.funck.mscourse.hroauth.clients;

import com.funck.mscourse.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

    @GetMapping("/search")
    Optional<User> findByEmail(@RequestParam String email);

}
