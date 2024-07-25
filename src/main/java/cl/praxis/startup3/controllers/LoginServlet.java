package cl.praxis.startup3.controllers;
import cl.praxis.startup3.models.AddressDTO;
import cl.praxis.startup3.models.CarDTO;
import cl.praxis.startup3.models.UserDTO;
import cl.praxis.startup3.services.*;
import cl.praxis.startup3.services.impl.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private IUserService objUserService;
    private IAddressService objAddressService;
    private ICarService objCarService;
    private IRoleUserService objRoleUserService;

    @SneakyThrows
    public void init() {
        objUserService = new UserService();
        objAddressService = new AddressService();
        objCarService = new CarService();
        objRoleUserService = new RolUserService();
    }

    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

       String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "viewCars":
                getAllCars(req, res);
                break;
            default:
                viewFormLogin(req, res);
                break;
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        validateLogin(req, res);

    }

    public void viewFormLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("index.jsp");
    }
        public void validateLogin(HttpServletRequest req, HttpServletResponse res) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            String message  = objUserService.validateLogin(email, password);

            if(!message.isEmpty()) {
                req.setAttribute("message", message);
                req.getRequestDispatcher("login.jsp").forward(req, res);
            } else {
                UserDTO user = objUserService.getUser(email);
                AddressDTO address = objAddressService.getAddress(user.getId());
                String role = objRoleUserService.roleUser(user.getId());
                req.setAttribute("user", user);
                req.setAttribute("address", address);
                req.setAttribute("role", role);


                boolean isAdmin = "administrador".equals(role);
                req.setAttribute("isAdmin", isAdmin);

                req.getRequestDispatcher("home.jsp").forward(req, res);
            }
        } catch (ServletException  | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewListCars(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("cars.jsp");
    }
    public void getAllCars(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<CarDTO> listCars = objCarService.getAllCars();
        System.out.println("Esta es la lista de: " + listCars);

        req.setAttribute("listCars", listCars);
        req.getRequestDispatcher("cars.jsp").forward(req, res);
    }

}
