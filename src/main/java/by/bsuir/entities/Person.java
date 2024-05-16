package by.bsuir.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "people")
public class Person implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="surname")
    private String surname;

    @Column(name="email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
