package se.lexicon.g52todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g52todoapi.domain.dto.UserDTOForm;
import se.lexicon.g52todoapi.domain.dto.UserDTOView;
import se.lexicon.g52todoapi.service.UserService;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //http://localhost:8080/api/v1/users
    //http://localhost:8080/api/v1/users?email=test@email.com

    @GetMapping
    public ResponseEntity<UserDTOView> doGetUserByEmail(@RequestParam String email){
        UserDTOView responseBody = userService.getByEmail(email);
        return ResponseEntity.ok(responseBody);
    }



    //POST http://localhost:8080/api/v1/users (Send with RequestBody)

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<UserDTOView> doRegister(@RequestBody UserDTOForm form){
        UserDTOView dtoView = userService.register(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoView);
    }

    //http://localhost:8080/api/v1/users/disable
    //http://localhost:8080/api/v1/users/disable?email=test@email.com

    @PutMapping("/disable")
    public ResponseEntity<Void> doDisableUserByEmail(@RequestParam("email") String email) {
        userService.disableByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //http://localhost:8080/api/v1/users/enable
    //http://localhost:8080/api/v1/users/enable?email=test@email.com
    @PutMapping("/enable")
    public ResponseEntity<Void> doEnableUserByEmail(@RequestParam("email") String email) {
        userService.enableByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
