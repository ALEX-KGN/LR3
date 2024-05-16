package by.bsuir.servlet;

import by.bsuir.entities.City;
import by.bsuir.service.CityService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@WebServlet("/cities")
public class CityServlet extends HttpServlet {
    @EJB
    private CityService cityService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "showForm":
                showForm(request, response);
                break;
            case "add":
                addCity(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateCity(request, response);
                break;
            case "delete":
                deleteCity(request, response);
                break;
            default:
                listCities(request, response);
                break;
        }
    }

    private void listCities(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<City> cities = cityService.getCities();
        request.setAttribute("cities", cities);
        request.getRequestDispatcher("city-list.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("city-form.jsp").forward(request, response);
    }

    private void addCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameCity = request.getParameter("nameCity");
        cityService.createCity(nameCity);
        response.sendRedirect(request.getContextPath() + "/cities?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            long id = Long.parseLong(request.getParameter("id"));
            City city = cityService.getCity(id);
            request.setAttribute("city", city);
            request.getRequestDispatcher("city-form.jsp").forward(request, response);
    }

    private void updateCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String nameCity = request.getParameter("nameCity");
        cityService.updateCity(id, nameCity);
        response.sendRedirect(request.getContextPath() + "/cities?action=list");
    }

    private void deleteCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        cityService.deleteCity(id);
        response.sendRedirect(request.getContextPath() + "/cities?action=list");
    }
}