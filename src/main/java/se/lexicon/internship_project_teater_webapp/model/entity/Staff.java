package se.lexicon.internship_project_teater_webapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Staff extends User {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @Column(unique = true, nullable = false, length = 30)
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Calendar> calendarList;
    private Role role;

    public Staff(String firstName, String lastName, LocalDate birthDate, List<Calendar> calendarList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.calendarList = calendarList;
        this.role = Role.ROLE_STAFF;
    }

    public Staff(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.role = Role.ROLE_STAFF;
    }


}
