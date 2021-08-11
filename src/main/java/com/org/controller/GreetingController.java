package com.org.controller;

import com.org.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
//@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
     * Ability to return JSON data using GET method
     * @param name
     * Execution URL :
     * 1. curl localhost:8080/greeting/get -w "\n"
     * 2. curl localhost:8080/greeting/get?name=Pooja -w "\n"
     * @return
     */

    @GetMapping("/get")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /*
     * Ability to return JSON data using POST method
     * @param greeting
     *  Execution URL : curl -X POST -H "Message-Type: application/json" -d '{"Message":"Pooja"}' "http://localhost:8080/greeting/post" -w "\n"
     * @return
     */

    @PostMapping("/post")
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(), String.format(template, greeting.getMessage()));
    }

    /*
     * Ability to return JSON data using PUT method
     * @param id
     * @param name
     * Execution URL : curl -X PUT localhost:8080/greeting/put/1/?name=pooja -w "\n"
     * @return
     */

    @PutMapping("/put/{id}")
    public Greeting putGreeting(@PathVariable int id, @RequestParam(value = "name") String name) {
        return new Greeting(id, String.format(template, name));
    }
}