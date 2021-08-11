package com.org.service;

import com.org.model.Greeting;
import com.org.model.User;
import com.org.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServices  implements IGreetingService{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private GreetingRepository greetingRepository;

    /**
     * Return message to the Controller
     * @return
     */
    public String getMessage() {
        return "Hello World";
    }

//    public String getGreeting(String firstName, String lastName) {
//        return String.format(firstName, lastName);
//    }


    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty())? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreeting(long id) {
        return null;
    }
}