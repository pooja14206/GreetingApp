/*
  * UC4: Ability for the Greeting App to save the Greeting Message in the Repository
  * UC5: Ability for the Greeting App to find a Greeting Message by Id in the Repository
 */
package com.org.controller;

import com.org.model.Greeting;
import com.org.model.User;
import com.org.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingControllerWithDB {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private IGreetingService greetingService;

    /*
     * Ability to Store in DB an then return list using GET method from the Database
     * @param: name
     * Execution URL : curl -X GET "http://localhost:8080/greeting" -w "\n"
     * @return
     */
    @GetMapping(value = {"","/","/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    /*
     * Ability to get greeting message by Id using GET method from the Database
     * @param: id
     * Execution URL : curl -X GET "http://localhost:8080/greeting/greeting/5" -w "\n"
     * @return
     */
    @GetMapping("/greeting/{id}")
    public Greeting getById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }
}