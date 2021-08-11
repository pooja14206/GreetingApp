package com.org.service;

import com.org.model.Greeting;
import com.org.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreeting(long id);
}
