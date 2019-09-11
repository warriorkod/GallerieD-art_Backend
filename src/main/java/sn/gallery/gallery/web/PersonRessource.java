package sn.gallery.gallery.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import sn.gallery.gallery.domain.Person;
import sn.gallery.gallery.service.PersonService;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Slf4j
public class PersonRessource {
    private PersonService personService;

    public PersonRessource(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public Person createPerson(@Valid @RequestBody Person person) throws Exception {
        if (person.getId() != null) {
            throw new Exception("A new person cannot already have an ID");
        }
        try {
            personService.create(person);
        } catch (Exception e) {
            log.error("Error creating person", e);
        }
        return person;
    }

    @GetMapping("/person")
    public Page<Person> findAllPerson(Pageable pageable) {
        return personService.getAllPerson(pageable);
    }

}
