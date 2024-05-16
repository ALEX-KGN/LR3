package by.bsuir.service;

import by.bsuir.dao.CitiesDAO;
import by.bsuir.dao.PeopleDAO;
import by.bsuir.entities.City;
import by.bsuir.entities.Person;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import javax.naming.NamingException;
import java.util.List;

@Stateless
public class CityService {
    @EJB
    private CitiesDAO citiesDAO;
    public City getCity(long id) {
        return citiesDAO.getCity(id);
    }

    public List<City> getCities() {
        return citiesDAO.getAllCities();
    }

    public void createCity(String nameCity){
        City city = new City();
        city.setNameCity(nameCity);
        citiesDAO.addCity(city);
    }

    public void deleteCity(long id){
        citiesDAO.deleteCity(id);
    }

    public void updateCity(long id, String nameCity){
        City city = getCity(id);
        city.setNameCity(nameCity);
        citiesDAO.updateCity(city);
    }

}
