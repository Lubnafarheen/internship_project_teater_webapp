package se.lexicon.internship_project_teater_webapp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.internship_project_teater_webapp.model.entity.Account;

import java.util.Optional;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;
    Account account;

    @BeforeEach
    public void setup() {
        account = accountRepository.save(new Account("azadeh", "123456"));
    }

    @Test
    public void test1_findByUsername() {
        Optional<Account> accountOptional = accountRepository.findByUsername("azadeh");
        Assertions.assertTrue(accountOptional.isPresent());
        Assertions.assertEquals(accountOptional.get().getUsername(), "azadeh");
    }

    @Test
    public void test2_resetPassword() {

        accountRepository.resetPassword("azadeh","111111");
        Optional<Account> accountOptional = accountRepository.findByUsername("azadeh");
        Assertions.assertTrue(accountOptional.isPresent());
        Assertions.assertEquals(accountOptional.get().getPassword(), "111111");

    }

}


