/*
 * UC2 : Extend GreetingController to use Services Layer to get Simple Greeting message HELLO WORLD
 * UC3 : Ability for the Greeting App to give Greeting message with
 *		- User First Name and Last Name or
 *		- With just First Name or Last Name based on User attributes provides or
 *      - Just Hello World.
 */
package com.org.controller;

import com.org.service.GreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloGreetingController {

    /*
     * Creating object for GreetingServices.class
     */
    @Autowired
    private GreetingServices greetingService;

    /*
     * Ability to return message using GET method from the service package class
     * Execution URL : http://localhost:8080/getHello
     * @return
     */

    @GetMapping(value = "/getHello")
    public ResponseEntity<String> getHelloMessage() {
        return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
    }
    //....................................UC3.................................
    /*
     * Purpose : Ability to return message using GET method from the service class
     * @param firstName
     * @param lastName
     * Execution URL :
     *  1. http://localhost:8080/greeting/getMessage
     *  2. http://localhost:8080/greeting/getMessage?fname=Pooja
     *  3. http://localhost:8080/greeting/getMessage?fname=Pooja&lname=Roy
     * @return
     */

//    @GetMapping(value = "greeting/getMessage")
//    public ResponseEntity<String> greeting(@RequestParam(value = "firstName", defaultValue = "Hello World") String firstName,
//                                           @RequestParam(value = "lastName", defaultValue = "") String lastName) {
//        return new ResponseEntity<>(greetingService.getGreeting(firstName, lastName), HttpStatus.OK);
//    }
}
