/*
  * UC4: Ability for the Greeting App to save the Greeting Message in the Repository.
  * UC5: Ability for the Greeting App to find a Greeting Message by Id in the Repository.
  * UC6: Ability for the Greeting App to List all the Greeting Messages in the Repository.
  * UC8: Ability for the Greeting App to delete a Greeting Messages in the Repository
  * UC7: Ability for the Greeting App to update a Greeting Messages in the Repository
 */
package com.org.controller;

import com.org.model.Greeting;
import com.org.model.User;
import com.org.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    /*
     * Ability to get  All greeting message in list using GET method from the Database
     * Execution URL : curl -X GET http://localhost:8080/greeting/greetings -w "\n"
     * @return
     */
    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings(){
        return greetingService.getAllGreetings();
    }

    /*
     * Ability to update greeting message from list using UPDATE method from the Database
     * Execution URL :
     * @return
     */
    @PutMapping("/greeting/{id}")
    public Greeting updateById(@PathVariable Long id, @RequestBody User user){
        return greetingService.updateGreeting(id,user);
    }

    /*
     * Ability to delete greeting message from list using DELETE method from the Database
     * Execution URL : curl -X DELETE http://localhost:8080/greeting/2 -w "\n"
     * @return
     */
    @DeleteMapping("/{id}")
    public Greeting deleteById(@PathVariable Long id){
        return greetingService.deleteGreeting(id);
    }
}