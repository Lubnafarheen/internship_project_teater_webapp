package se.lexicon.internship_project_teater_webapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.internship_project_teater_webapp.model.entity.Account;
import se.lexicon.internship_project_teater_webapp.model.entity.Role;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    @GetMapping("/api/v1/account/")
    public ResponseEntity<List<Account>> getAll(){
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Lubna", Role.ROLE_MEMBER));
        return ResponseEntity.ok(accounts); //ok means http response code 200(if returns successfully)
    }
}
