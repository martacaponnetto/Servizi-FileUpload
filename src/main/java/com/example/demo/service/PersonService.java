package com.example.demo.service;

import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonEntity> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<PersonEntity> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public PersonEntity createOrUpdatePerson(PersonEntity person) {
        return personRepository.save(person);
    }

    public void deletePersonById(Long id) throws Exception {
        Optional<PersonEntity> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            personRepository.deleteById(id);
        } else {
            throw new Exception("Person not found with id: " + id);
        }
    }
}
