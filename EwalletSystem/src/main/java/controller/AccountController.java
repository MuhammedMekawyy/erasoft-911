package controller;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model.Account;
import service.AccountService;
import service.serviceImpl.AccountServiceImpl;



@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Resource(name = "hamada")
    private DataSource dataSource;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

    private AccountService getAccountService() {
        return new AccountServiceImpl(dataSource);
    }

    private Account getSignupAccount(HttpServletRequest request) {

        String username = request.getParameter("username");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        float age= Float.parseFloat( request.getParameter("age"));

        return new Account(username,password,phoneNumber,age);
    }

    private Account getLoginAccount(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        return new Account(username, password);
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
            return "An unexpected error occurred.";
        }

        // ================= Custom Exceptions =================

        if (message.contains("INVALID_LOGIN")) {
            return "Username or password is incorrect.";
        }

        if (message.contains("PASSWORD_UPDATE_FAILED")) {
            return "Failed to update password.";
        }

        if (message.contains("PASSWORD_MISMATCH")) {
            return "Password and Confirm Password do not match.";
        }

        if (message.contains("USER_NOT_FOUND")) {
            return "Account not found.";
        }

        // ================= Oracle Errors =================

        if (message.contains("ORA-00001")) {
            return "Username or phone number already exists.";
        }

        if (message.contains("ORA-01400")) {
            return "Required fields cannot be empty.";
        }

        if (message.contains("ORA-12899")) {
            return "One or more fields exceed the maximum allowed length.";
        }

        if (message.contains("CK_ACCOUNT_AGE")) {
            return "Age must be at least 18 years.";
        }

        if (message.contains("CK_ACCOUNT_BALANCE")) {
            return "Balance cannot be negative.";
        }

        if (message.contains("CK_USERNAME_LENGTH")) {
            return "Username must be at least 3 characters long.";
        }

        if (message.contains("CK_USERNAME_FIRST_CHAR")) {
            return "Username must start with an uppercase letter.";
        }

        if (message.contains("CK_USERNAME_ONLY_LETTERS")) {
            return "Username must contain only letters.";
        }

        if (message.contains("CK_PASSWORD_LENGTH")) {
            return "Password must be at least 8 characters long.";
        }

        if (message.contains("CK_PHONE_NUMBER")) {
            return "Phone number must be a valid Egyptian mobile number.";
        }

        return message;
    }
    
    // ================= Controller Methods =================

    private void signup(HttpServletRequest request,
                        HttpServletResponse response)
            throws IOException {

        if (getAccountService().createAccount(getSignupAccount(request))) {
            response.sendRedirect("View/Signup.html");
        }
    }

    private void login(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {

    	Account account = getAccountService().login(getLoginAccount(request));

    	if (account != null) {

    	    HttpSession session = request.getSession();
    	    session.setAttribute("account", account);

    	    response.sendRedirect(request.getContextPath() + "/View/mainProfile.jsp");

    	} else {

    	    throw new RuntimeException("INVALID_LOGIN");
    	}
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect("View/Signup.html");
    }
    
    
    private void deleteAccount(HttpServletRequest request,HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("account") == null) {
            throw new RuntimeException("User is not logged in.");
         }

        Account account = (Account) session.getAttribute("account");

         if (getAccountService().deleteAccountByUsername(account.getUsername())) {

               session.invalidate();

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

	    if (!getAccountService().accountExistsByUsername(username)) {
	        throw new RuntimeException("USER_NOT_FOUND");
	    } 
	    
	    if (getAccountService().updateAccountPassword(username, newPassword)) {

	    	response.sendRedirect("View/Signup.html");
	    	
	    }else {
            throw new RuntimeException("PASSWORD_UPDATE_FAILED");
        }

		
	}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
