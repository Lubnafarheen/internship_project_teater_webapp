package se.lexicon.internship_project_teater_webapp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.internship_project_teater_webapp.model.entity.Contact;

import java.util.Optional;

@DataJpaTest
public class ContactRepositoryTest {

    @Autowired
    ContactRepository testObject;
    Contact createdContact = null;

    @BeforeEach
    public void setup() {
        createdContact = testObject.save(new Contact("0762271234", "kungsmarken", "karlskrona"));
    }

    @Test
    public void test1_findById() {
        Optional<Contact> contactOptional = testObject.findById(createdContact.getId());
        Assertions.assertTrue(contactOptional.isPresent());
        Contact actual = createdContact;
        Contact expected = contactOptional.get();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void test2_create() {
        Contact created = testObject.save(new Contact("1234567890", "kungsmarken", "karlskrona"));
        Assertions.assertNotNull(created);
    }

}
