package com.example.userservice.service;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    void testCreateUser(){

        User user = new User(0,"jean","jean@test.com");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        User result = userService.createUser("jean","jean@test.com");

        Assertions.assertEquals(user, result);
    }

    @Test
    void testGetUserById(){

        User user = new User(0,"jean","jean@test.com");
        Mockito.when(userRepository.findById(0)).thenReturn(Optional.of(user));

        User result = userService.getUserById(0);

        Assertions.assertEquals(user, result);

    }
}
