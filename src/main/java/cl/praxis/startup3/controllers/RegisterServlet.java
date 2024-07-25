package cl.praxis.startup3.controllers;

import cl.praxis.startup3.models.AddressDTO;
import cl.praxis.startup3.models.UserDTO;
import cl.praxis.startup3.services.IAddressService;
import cl.praxis.startup3.services.IUserService;
import cl.praxis.startup3.services.impl.AddressService;
import cl.praxis.startup3.services.impl.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private IUserService objUserService;
    private IAddressService objAddressService;

    @SneakyThrows
    public void init() {
        objUserService = new UserService();
        objAddressService = new AddressService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        viewFormRegister(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        addUser(req, res);
    }

    public void viewFormRegister(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("register.jsp");
    }

    public void addUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        UserDTO user = new UserDTO();
        AddressDTO address = new AddressDTO();

        // Parámetros UserDTO
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String nick = req.getParameter("nick");
        String password = req.getParameter("password");
        int weight = Integer.parseInt(req.getParameter("weight"));

        // Paramétros AddressDTO
        String street =  req.getParameter("street");
        int number = Integer.parseInt(req.getParameter("number"));

            user.setEmail(email);
            user.setName(name);
            user.setNick(nick);
            user.setPassword(password);
            user.setWeight(weight);

            address.setStreet(street);
            address.setNumber(number);

        UserDTO user1 = objUserService.getUser(email);

        if(null == user1) {
                UserDTO newUser = objUserService.insertedUser(email, user);
                address.setUserId(newUser.getId());
                objAddressService.insertAddress(address);

               res.sendRedirect("login.jsp");
            } else {
                req.setAttribute("message", "Usuario ya existe, intente con otro correo o vaya a login");
                req.getRequestDispatcher("register.jsp").forward(req, res);
            }
    }
}
