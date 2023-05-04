package se.lexicon.internship_project_teater_webapp.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Staff extends User {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Calendar> calendarList;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH}
    )
    private List<Contact> contactInformation;

    private Role role;

    public Staff(String firstName, String lastName, LocalDate birthDate, List<Calendar> calendarList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.calendarList = calendarList;
        this.role = Role.ROLE_STAFF;
    }


}
