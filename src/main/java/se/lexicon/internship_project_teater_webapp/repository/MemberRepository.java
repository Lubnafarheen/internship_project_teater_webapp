package se.lexicon.internship_project_teater_webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.internship_project_teater_webapp.model.entity.Member;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {

    List<Member> findAllByFirstName(String firstName);

    List<Member> findAllByLastName(String lastName);

    List<Member> findAllByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    Optional<Member> findByEmail(String email);


}
