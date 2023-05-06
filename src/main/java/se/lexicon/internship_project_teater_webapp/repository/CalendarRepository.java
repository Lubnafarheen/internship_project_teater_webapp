package se.lexicon.internship_project_teater_webapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.internship_project_teater_webapp.model.entity.Calendar;
import se.lexicon.internship_project_teater_webapp.model.entity.Event;
import java.util.List;

@Repository
public interface CalendarRepository extends CrudRepository<Calendar, Integer> {

    List<Calendar> findByCalendarMode(String calendarMode);

    //find all the calendars which have a specific event added to them.
    List<Calendar> findByEventsContains(Event event);

    //find all the calendars which have an event with the specified eventId.
    @Query("select c from Calendar c join c.events e where e.id = :eventId")
    List<Calendar> findCalendarsByEventId(@Param("eventId") Integer eventId);


}
