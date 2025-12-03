package ma.farm.controller;
import ma.farm.model.User;
import ma.farm.dao.UserDAO;

public class LoginController {
    public static User authenticate(String email, String password) {
        UserDAO userDAO = new UserDAO();
        if (userDAO.validate(email, password)) return userDAO.getUserByEmail(email);
        else throw new SecurityException("Invalid email or password");
    }

    public static void login(String email, String password) {
        try {
            User user = authenticate(email, password);
            System.out.println("Login successful for user: " + user.getUsername());
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}