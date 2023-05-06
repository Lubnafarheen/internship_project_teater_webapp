package se.lexicon.internship_project_teater_webapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String phone;
    private String address;
    private String city;
    private String zipcode;
    

    public Contact(String phone, String address, String city) {
        this.phone = phone;
        this.address = address;
        this.city = city;
    }
}
