package se.lexicon.internship_project_teater_webapp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.internship_project_teater_webapp.model.entity.Staff;

import java.time.LocalDate;
import java.util.List;

@Transactional
@DataJpaTest
public class StaffRepositoryTest {

    @Autowired
    StaffRepository staffRepository;

    Staff staff1;


    @BeforeEach
    public void setup() {
        staff1 = staffRepository.save(new Staff("staff1", "staff1", LocalDate.parse("2020-01-01")));
    }

   /* @Test
    public void test1_findByFirstName() {

        List<Staff> staffList = staffRepository.findAllByFirstName("staff");
        Assertions.assertEquals(1, staffList.size());

    }


    @Test
    public void test1_findByLastName() {

        List<Staff> staffList = staffRepository.findAllByLastName("test");
        Assertions.assertEquals(0, staffList.size());

    }*/


}

