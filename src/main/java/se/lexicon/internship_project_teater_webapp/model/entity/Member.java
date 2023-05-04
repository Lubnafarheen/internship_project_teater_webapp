package se.lexicon.internship_project_teater_webapp.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Member extends User  {

    private String firstName;
    private String lastName;

    private LocalDate birthDate;

    @Column(unique = true, nullable = false, length = 30)
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Event> events;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH}
    )
    private List<Contact> contactInformation;

    private Role role;
    public Member(String firstName, String lastName, LocalDate birthDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.role = Role.ROLE_MEMBER;

    }
}
