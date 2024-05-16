package by.bsuir.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "cities")
public class City implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name_city")
    private String nameCity;

    @OneToMany(mappedBy = "city")
    private List<Person> people;
}
