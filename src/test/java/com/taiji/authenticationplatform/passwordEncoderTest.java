package com.taiji.authenticationplatform;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class passwordEncoderTest {
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Test
    public  void test1() {
        System.out.println("加密后："+passwordEncoder().encode("secret2"));
    }
}
