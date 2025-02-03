package se.lexicon.g52todoapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    //http://localhost:8080/index
    //http://localhost:8080/home
    @RequestMapping(method = RequestMethod.GET, path= { "/index" , "/home"})
    public String helloWorld() {
        return "Hello Group 52";
    }
    //http://localhost:8080/information
    //http://localhost:8080/information?message=hello%20group%2052
    @GetMapping("/information")
    public ResponseEntity<String> responseMessage (@RequestParam(defaultValue = "Information Displayed Here 👀") String message){
        System.out.println("API CALL -- Executed method on localhost:8080/information Received message: " + message);

        return ResponseEntity.status(202).body("<h1> Information process: " + message + "</h1>");
    }

    //http://localhost:8080/54
    @GetMapping("/{id}")
    public ResponseEntity<String> pathVariable(@PathVariable(name = "id") String id){

        String message = "<h1> Your Identification: " + id + "</h1>";

//        return ResponseEntity.status(200).body(message);
//        return ResponseEntity.status(HttpStatus.OK).body(message);
        return ResponseEntity.ok(message);

    }



    //http://localhost:8080/
    @GetMapping("/")
    public ResponseEntity<Void> foo(){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}
