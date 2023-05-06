package se.lexicon.internship_project_teater_webapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.internship_project_teater_webapp.model.entity.Account;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, String > {

    Optional<Account> findByUsername(String username);

    Boolean existsByUsername(String username);

    //update password through username
    @Modifying
    @Query("update Account a set a.password = : newPassword where a.username = : username ")
    void resetPassword(@Param("username")String username, @Param("newPassword") String newPassword);

}
