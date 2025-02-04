package se.lexicon.g52todoapi.controller;


import jakarta.transaction.Transactional;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g52todoapi.domain.dto.*;
import se.lexicon.g52todoapi.repository.PersonRepository;
import se.lexicon.g52todoapi.repository.UserRepository;
import se.lexicon.g52todoapi.service.PersonService;
import se.lexicon.g52todoapi.service.UserService;
import se.lexicon.g52todoapi.service.impl.PersonServiceImpl;
import se.lexicon.g52todoapi.service.impl.UserServiceImpl;

import java.util.List;


@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    private final UserService userService;
    private final PersonService personService;
    //Todo: Implement Controller



    @Autowired
    public PersonController(PersonService personService, UserService userService) {
        this.personService = personService;
        this.userService = userService;
    }


    @PostMapping() //ok
    public ResponseEntity<PersonDTOView> doRegister(@RequestBody PersonDTOForm form) {
        PersonDTOView dtoView = personService.create(form);

        return ResponseEntity.ok(dtoView);
    }

    //This is from userservice doing it here since I started wrong and did all user stuff here
    @GetMapping("/auth") //ok
    public boolean doAuthorize(@RequestParam String email, @RequestParam String password) {

        return userService.authorizeUser(email, password);
    }

    @GetMapping() //ok
    public ResponseEntity<PersonDTOView> doGetUserById(@RequestParam Long id) {
        PersonDTOView resultUser =  personService.findById(id);
        if(resultUser == null) {
            return null;
        }
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getallusers") //ok
    public ResponseEntity<List<PersonDTOView>> getAllUsers() {
        List<PersonDTOView> resultUsers = personService.findAll();
        if(resultUsers.isEmpty()) {
            return null;
        }

        return ResponseEntity.ok(resultUsers);
    }

    @PutMapping("/updateperson") //ok, only changing name is is now
    public ResponseEntity<PersonDTOView> doUpdatePerson(@RequestBody PersonDTOForm form) {
        PersonDTOView dtoView = personService.update(form);
        if(dtoView == null) {
            return null;
        }

        return ResponseEntity.ok(dtoView);
    }


    @DeleteMapping("/deleteperson") //Tried to get this working with RequestParam with no luck tried with Requestbody and this does the trick
    public ResponseEntity<Void> doDeletePerson(@RequestBody Long id) {
        if(personService.findById(id) == null) {
            return null;
        }
        personService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
