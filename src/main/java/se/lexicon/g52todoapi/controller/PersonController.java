package se.lexicon.g52todoapi.controller;


import jakarta.transaction.Transactional;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.g52todoapi.domain.dto.*;
import se.lexicon.g52todoapi.service.PersonService;
import se.lexicon.g52todoapi.service.impl.PersonServiceImpl;
import se.lexicon.g52todoapi.service.impl.UserServiceImpl;

import java.util.List;

@Transactional
@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final UserServiceImpl userServiceImpl;
    private final PersonServiceImpl personServiceImpl;
    //Todo: Implement Controller

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService, UserServiceImpl userServiceImpl, PersonServiceImpl personServiceImpl) {
        this.personService = personService;
        this.userServiceImpl = userServiceImpl;
        this.personServiceImpl = personServiceImpl;
    }

    @GetMapping
    public String test(){
        System.out.println("---------------------------------------------------------");
        return "test";
    }

    @PostMapping() //ok
    public ResponseEntity<PersonDTOView> doRegister(@RequestBody PersonDTOForm form) {
        PersonDTOView dtoView = personService.create(form);

        return ResponseEntity.ok(dtoView);
    }

    //This is from userservice doing it here since I started wrong and did all user stuff here
    @GetMapping("/auth") //ok
    public boolean doAuthorize(@RequestParam String email, @RequestParam String password) {

        return userServiceImpl.authorizeUser(email, password);
    }

    @GetMapping("/{id}") //ok
    public ResponseEntity<PersonDTOView> doGetUserById(@PathVariable Long id) {
        PersonDTOView resultUser =  personServiceImpl.findById(id);
        if(resultUser == null) {
            return null;
        }
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getallusers") //ok
    public ResponseEntity<List<PersonDTOView>> getAllUsers() {
        List<PersonDTOView> resultUsers = personServiceImpl.findAll();
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
        if(personServiceImpl.findById(id) == null) {
            return null;
        }
        personServiceImpl.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
