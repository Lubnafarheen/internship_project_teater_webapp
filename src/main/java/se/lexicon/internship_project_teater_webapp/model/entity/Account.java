package se.lexicon.internship_project_teater_webapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

    @Id
    //  @Column(nullable = false, unique = true)
    private String username;
    // @Column(nullable = false)
    private String password;

    public Account(String username) {
        this.username = username;
    }

    public Account(String username, Role role) {
        this.username = username;

    }
}
