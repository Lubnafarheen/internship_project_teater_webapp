package se.lexicon.internship_project_teater_webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.internship_project_teater_webapp.model.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {


}
