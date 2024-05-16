package by.bsuir.service;

import by.bsuir.dao.PeopleDAO;
import by.bsuir.entities.City;
import by.bsuir.entities.Person;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import javax.naming.NamingException;
import java.util.List;

@Stateless
public class PeopleService {
    @EJB
    private PeopleDAO peopleDAO;
    @EJB
    private CityService cityService;
    public Person getPerson(long id) {
        return peopleDAO.getPerson(id);
    }

    public List<Person> getPeople() {
        return peopleDAO.getAllPeople();
    }

    public void createPerson(String name, String email, long cityId){
        City city = cityService.getCity(cityId);
        Person person = Person.builder()
                .surname(name)
                .email(email)
                .city(city)
                .build();
      peopleDAO.addPerson(person);
    }

    public void deletePerson(long id){
        Person person = getPerson(id);
        peopleDAO.deletePerson(person);
    }

    public void updatePerson(long id, String name, String email, long cityId){
        Person person = getPerson(id);
        City city = cityService.getCity(cityId);
        person.setCity(city);
        person.setSurname(name);
        person.setEmail(email);
        peopleDAO.updatePerson(person);
    }

}
