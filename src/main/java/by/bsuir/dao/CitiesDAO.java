package by.bsuir.dao;

import by.bsuir.entities.City;
import by.bsuir.entities.Person;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.naming.NamingException;
import java.util.List;

@Stateless
public class CitiesDAO {
    @PersistenceContext(unitName = "name")
    private EntityManager entityManager;

    public List<City> getAllCities() {
        return entityManager.createQuery("SELECT c from City c", City.class).getResultList();
    }

    public City getCity(long id) {
        return entityManager.createQuery("SELECT c from City c where c.id = "+ id, City.class).getSingleResult();
    }

    public void addCity(City city) {
        entityManager.persist(city);
    }

    public void updateCity(City city) {
        entityManager.merge(city);
    }

    public void deleteCity(long id) {
        City city = getCity(id);
        entityManager.remove(city);
    }

}
