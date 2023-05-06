package se.lexicon.internship_project_teater_webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.internship_project_teater_webapp.model.entity.Staff;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer> {

    List<Staff> findAllByFirstName(String firstName);

    List<Staff> findAllByLastName(String lastName);

    List<Staff> findAllByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    Optional<Staff> findByEmail(String email);

    // Find all staff members who have an account with the given username
    List<Staff> findAllByAccount_Username(String username);

    // Find all staff members who were born after the given date
    List<Staff> findAllByBirthDateAfter(LocalDate birthDate);


}
