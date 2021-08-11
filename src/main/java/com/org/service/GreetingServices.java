package com.org.service;

import com.org.model.Greeting;
import com.org.model.User;
import com.org.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public String getGreeting(String firstName, String lastName) {
        return String.format(firstName, lastName);
    }


    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty())? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(Long id) {
       return greetingRepository.findById(id).get();
        }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
        }

    @Override
    public Greeting deleteGreeting(Long id) {
        return greetingRepository.findById(id).map(greeting -> {
                    this.greetingRepository.deleteById(id);
                    return greeting;
                    }).get();
    }


}