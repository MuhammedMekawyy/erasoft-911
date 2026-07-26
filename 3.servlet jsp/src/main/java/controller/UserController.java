package controller;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Users;
import service.UserService;
import service.impl.UserServiceImpl;

// http://localhost:8080/ItemsProject/UserController?action=signup
// http://localhost:8080/ItemsProject/UserController?action=login

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "hamada")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String action = request.getParameter("action");

            if (Objects.isNull(action)) {
                response.sendRedirect("View/Signup.html");
                return;
            }
            
            // Logout does not require login check
            if ("logout".equals(action)) {
                logout(request, response);
                return;
            }
            


            switch (action) {

            case "signup":
                signup(request, response);
                break;

            case "login":
                login(request, response);
                break;
                
            case "deleteAccount":
            	deleteAccount(request, response);
                break;
                
            case "resetPassword":
            	resetPassword(request, response);
                break;
                
                
            default:
                response.sendRedirect("View/Signup.html");
            }

        } catch (Exception e) {

            request.setAttribute("errorMessage", getErrorMessage(e));
            forward(request, response, "/View/Error.jsp");
        }
    }

	// ================= Helper Methods =================

    private UserService getUserService() {
        return new UserServiceImpl(dataSource);
    }

    private Users getSignupUser(HttpServletRequest request) {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        return new Users(username, email, password);
    }

    private Users getLoginUser(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        return new Users(username, password);
    }

    private void forward(HttpServletRequest request,
                         HttpServletResponse response,
                         String page) {

        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private String getErrorMessage(Exception e) {

        Throwable cause = e.getCause();
        String message = (cause != null) ? cause.getMessage() : e.getMessage();

        if (message == null) {
            return "Unexpected error.";
        }
        
        if (message.contains("INVALID_LOGIN")) {
            return "Username or password is incorrect.";
        }
        
        if (message.contains("PASSWORD_UPDATE_FAILED")) {
            return "Failed to update password.";
        }
        
        if (message.contains("USER_NOT_FOUND")) {
            return "USER_NOT_FOUND.";
        }

        if (message.contains("ORA-00001")) {
            return "Username or Email already exists.";
        }

        if (message.contains("ORA-01400")) {
            return "Required fields cannot be empty.";
        }

        if (message.contains("ORA-12899")) {
            return "Username, Email, or Password is too long.";
        }

        return e.getMessage();
    }
    
    private String getLoggedinUsername(HttpServletRequest request) {
    	
    	Cookie [] cookies =request.getCookies(); 
    	
    	for(Cookie cookie : cookies) { 
    		 if("username".equals(cookie.getName())) {
    			 return cookie.getValue();
    		 }
    		 
    		 
    	}
    	return null; 
    	
    }
    		
    		
  
    


    // ================= Controller Methods =================

    private void signup(HttpServletRequest request,
                        HttpServletResponse response)
            throws IOException {

        if (getUserService().createUser(getSignupUser(request))) {
            response.sendRedirect("View/Signup.html");
        }
    }

    private void login(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {

        Users user = getLoginUser(request);

        if (getUserService().userExist(user)) {

            Cookie cookie = new Cookie("username", user.getUsername());
            cookie.setMaxAge(60 * 60 * 24);
            cookie.setPath("/ItemsProject");
            response.addCookie(cookie);

            response.sendRedirect("/ItemsProject/ItemController");

        } else {

        	throw new RuntimeException("INVALID_LOGIN");
        }
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0);             
        cookie.setPath("/ItemsProject");  
        response.addCookie(cookie);

        response.sendRedirect("View/Signup.html");
    }
    

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		
    	String username = getLoggedinUsername(request);

        if (username == null) {
            throw new RuntimeException("User is not logged in.");
        }

        if (getUserService().deleteUserByUsername(username)) {

            Cookie cookie = new Cookie("username", "");
            cookie.setMaxAge(0);
            cookie.setPath("/ItemsProject");
            response.addCookie(cookie);

            response.sendRedirect("View/Signup.html");

        } else {
            throw new RuntimeException("Failed to delete account.");
        }
        
        
		
		
	} 
    
    
	private void resetPassword (HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username"); 
		String newPassword = request.getParameter("newPassword"); 
		String confirmedPassword= request.getParameter("confirmPassword");
		
		
	    if (!newPassword.equals(confirmedPassword)) {
	        throw new RuntimeException("PASSWORD_MISMATCH");
	    }

	    if (!getUserService().userExistsByUsername(username)) {
	        throw new RuntimeException("USER_NOT_FOUND");
	    } 
	    
	    if (getUserService().updateUserPassword(username, newPassword)) {

	    	response.sendRedirect("View/Signup.html");
	    	
	    }else {
            throw new RuntimeException("Failed to reset password.");
        }

		
	}



    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}