package sn.gallery.gallery.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.gallery.gallery.domain.Person;
import sn.gallery.gallery.repository.PersonRepository;

import java.util.Optional;

@Service
@Slf4j
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create (Person person){
        return personRepository.save(person);
    }

    public Page<Person> getAllPerson(Pageable pageable){
        return personRepository.findAll(pageable);
    }

    public Person getPersonById (Long id){
        return personRepository.getOne(id);
    }

    public Person updatePerson(Person person, Long id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (!optionalPerson.isPresent()){
            return null;
        }
        return personRepository.save(person);
    }

    public void delete(Long id) throws Exception {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()){
            personRepository.delete(optionalPerson.get());
        }
        else {
            throw new Exception("Person not found");
        }
    }
}
