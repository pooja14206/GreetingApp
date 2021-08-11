package com.org.service;

import com.org.model.Greeting;
import com.org.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(Long id);
    List<Greeting> getAllGreetings();
    Greeting deleteGreeting(Long id);
    public Greeting updateGreeting(long id,User user);
}