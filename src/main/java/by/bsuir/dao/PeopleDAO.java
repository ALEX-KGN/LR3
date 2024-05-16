package by.bsuir.dao;

import by.bsuir.entities.Person;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;


@Stateless
public class PeopleDAO {

    @PersistenceContext(unitName = "name")
    private EntityManager entityManager;

    public List<Person> getAllPeople() {
        return entityManager.createQuery("SELECT p from Person p", Person.class).getResultList();
    }

    public Person getPerson(long id) {
        return entityManager.createQuery("SELECT p from Person p where p.id = "+ id, Person.class).getSingleResult();
    }

    public void addPerson(Person person) {
        entityManager.persist(person);
    }

    public void updatePerson(Person person) {
        entityManager.merge(person);
    }

    public void deletePerson(Person person) {

        entityManager.remove(person);
    }



}
