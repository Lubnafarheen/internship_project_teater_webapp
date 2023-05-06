package se.lexicon.internship_project_teater_webapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.internship_project_teater_webapp.model.entity.Event;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    List<Event> findByTitleContainingIgnoreCase(String title);

    List<Event> findAllByOrderByIdAsc();

    //returns a list of events that have at least one attendee with the given name.
    @Query("select e from Event e join e.attendees a where lower(a.firstName) like %:name%")
    List<Event> findByAttendeeFirstName(@Param("name") String firstName);

    @Query("select e from Event e join e.attendees a where lower(a.lastName) like %:name%")
    List<Event> findByAttendeeLastName(@Param("name") String lastName);


    //returns a list of events that fall between a given start and end date.
    @Query("select e from Event e where e.startDateTime >= :start and e.endDateTime <= :end")
    List<Event> findBetweenDates(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    // returns a list of events that are scheduled to start after the given date and time.
    @Query("select e from Event e where e.startDateTime >= :now")
    List<Event> findUpcomingEvents(@Param("now") LocalDateTime now);

}
