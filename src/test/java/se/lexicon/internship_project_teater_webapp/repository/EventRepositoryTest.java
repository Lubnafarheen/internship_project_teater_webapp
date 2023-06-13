package se.lexicon.internship_project_teater_webapp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.internship_project_teater_webapp.model.entity.Account;
import se.lexicon.internship_project_teater_webapp.model.entity.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    EventRepository eventRepository;
    Event event1;

    @BeforeEach
    public void setup() {
        event1 = eventRepository.save(new Event("Test1", LocalDateTime.of(LocalDate.parse("2020-01-01"), LocalTime.parse("10:00")), LocalDateTime.of(LocalDate.parse("2020-01-01"), LocalTime.parse("12:00"))));
    }

    @Test
    public void test1_findAllByOrderByIdAsc() {
        Assertions.assertEquals(1, eventRepository.findAllByOrderByIdAsc().size());
    }


}


