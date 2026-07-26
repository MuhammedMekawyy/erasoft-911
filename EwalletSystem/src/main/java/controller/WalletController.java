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
import service.WalletService;
import service.serviceImpl.WalletServiceImpl;

@WebServlet("/WalletController")
public class WalletController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "hamada")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String action = request.getParameter("action");
          

            if (Objects.isNull(action)) {
                action = "mainProfile";
            }

            if (!isLoggedIn(request)) {
                response.sendRedirect("View/Signup.html");
                return;
            }

            switch (action.toLowerCase()) {

            case "mainprofile":
                mainProfile(request, response);
                break;

            case "deposit":
                deposit(request, response);
                break;

            case "withdraw":
                withdraw(request, response);
                break;

            case "transfer":
                transfer(request, response);
                break;

            case "showprofiledetails":
            
                showProfileDetails(request, response);
                break;

            default:
                throw new RuntimeException("INVALID_ACTION");
            }

        } catch (Exception e) {

            request.setAttribute("errorMessage", getErrorMessage(e));
            request.getRequestDispatcher("/View/Error.jsp")
                   .forward(request, response);
        }
    }

    // ================= Helper Methods =================

    private WalletService getWalletService() {
        return new WalletServiceImpl(dataSource);
    }

    private boolean isLoggedIn(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        return session != null && session.getAttribute("account") != null;
    }

    private Account getLoggedInAccount(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        return (Account) session.getAttribute("account");
    }

    private void redirectToProfile(HttpServletResponse response)
            throws IOException {

        response.sendRedirect("View/mainProfile.jsp");
    }

    private String getErrorMessage(Exception e) {

        Throwable cause = e.getCause();
        String message = cause != null ? cause.getMessage() : e.getMessage();

        if (message == null) {
            return "Unexpected error.";
        }

        // validation
        if (message.contains("Amount must be at least 100")) {
            return "Deposit or withdrawal amount must be at least 100.";
        }

        if (message.contains("multiples of 100")) {
            return "Amount must be in multiples of 100.";
        }

        if (message.contains("Insufficient")) {
            return "Insufficient balance.";
        }

        if (message.contains("Receiver")) {
            return "Receiver account was not found.";
        }

        if (message.contains("INVALID_ACTION")) {
            return "Invalid operation.";
        }

        if (message.contains("User is not logged in")) {
            return "Please login first.";
        }

        if (message.contains("ORA-02290")) {
            return "Operation violates one of the account constraints.";
        }

        if (message.contains("ORA-00001")) {
            return "Duplicate username or phone number.";
        }

        return message;
    }

    // ================= Controller Methods =================

    private void deposit(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        Account account = getLoggedInAccount(request);

        double amount =
                Double.parseDouble(request.getParameter("amount"));

        if (!getWalletService().DepositMoney(amount, account.getId())) {
            throw new RuntimeException("Deposit failed.");
        }

        redirectToProfile(response);
    }

    private void withdraw(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        Account account = getLoggedInAccount(request);

        double amount =
                Double.parseDouble(request.getParameter("amount"));

        if (!getWalletService().WithdrawMoney(amount, account.getId())) {
            throw new RuntimeException("Withdrawal failed.");
        }

        redirectToProfile(response);
    }

    private void transfer(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        Account account = getLoggedInAccount(request);

        double amount =
                Double.parseDouble(request.getParameter("amount"));

        String receiver =
                request.getParameter("receiverUsername");

        if (!getWalletService().transferMoney(
                amount,
                account.getId(),
                receiver)) {

            throw new RuntimeException("Transfer failed.");
        }

        redirectToProfile(response);
    }

    private void showProfileDetails(HttpServletRequest request,
                                    HttpServletResponse response)
            throws ServletException, IOException {

    	request.getRequestDispatcher("/View/ProfileDetails.jsp")
        .forward(request, response);
    }

    private void mainProfile(HttpServletRequest request,
                             HttpServletResponse response)
            throws IOException {

        redirectToProfile(response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}