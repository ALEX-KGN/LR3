package by.bsuir.servlet;

import by.bsuir.entities.City;
import by.bsuir.entities.Person;
import by.bsuir.service.CityService;
import by.bsuir.service.PeopleService;
import com.mysql.cj.xdevapi.Client;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet("/clients")
public class PeopleServlet extends HttpServlet {
    @EJB
    private PeopleService peopleService;

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
            case "list":
                listClients(request, response);
                break;
            case "showForm":
                showForm(request, response);
                break;
            case "add":
                addClient(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateClient(request, response);
                break;
            case "delete":
                deleteClient(request, response);
                break;
            default:
                listClients(request, response);
                break;
        }
    }

    private void listClients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> clients = peopleService.getPeople();
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("client-list.jsp").forward(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<City> cities = cityService.getCities();
        request.setAttribute("cities", cities);
        request.getRequestDispatcher("client-form.jsp").forward(request, response);
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        long cityId = Long.parseLong(request.getParameter("cityId"));
        peopleService.createPerson(name, email, cityId);
        response.sendRedirect(request.getContextPath() + "/clients?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Person person = peopleService.getPerson(id);
        List<City> cities = cityService.getCities();

        request.setAttribute("client", person);
        request.setAttribute("cities", cities);
        request.getRequestDispatcher("client-form.jsp").forward(request, response);
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int cityId = Integer.parseInt(request.getParameter("cityId"));
        peopleService.updatePerson(id, name, email, cityId);
        response.sendRedirect(request.getContextPath() + "/clients?action=list");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        peopleService.deletePerson(id);
        response.sendRedirect(request.getContextPath() + "/clients?action=list");
    }
}