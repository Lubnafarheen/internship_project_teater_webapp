package se.lexicon.internship_project_teater_webapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Member extends User {

    private String firstName;
    private String lastName;

    private LocalDate birthDate;

    @Column(unique = true, nullable = false, length = 30)
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Event> events;

    private Role role;

    public Member(String firstName, String lastName, LocalDate birthDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.role = Role.ROLE_MEMBER;

    }
}
