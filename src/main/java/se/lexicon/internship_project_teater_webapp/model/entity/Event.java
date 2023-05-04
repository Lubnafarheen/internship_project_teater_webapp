package se.lexicon.internship_project_teater_webapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    //@CreationTimestamp
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private String description;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "calendars_events",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "calendar_id")
    )
    private List<Calendar> calendars;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH}
    )
    private List<Member> attendees;

    public Event(String title, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.title = title;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.attendees = new ArrayList<Member>();
    }
    public void addMember(Member member) {
        attendees.add(member);
    }

    public void removeMember(Member member) {
        attendees.remove(member);
    }

}
