package controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Item;
import service.ItemService;
import service.UserService;
import service.impl.ItemServiceImpl;
import service.impl.UserServiceImpl;

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "hamada")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String action = request.getParameter("action");

            if (Objects.isNull(action)) {
                action = "showItems";
            }
            
            
            // Check login for all other actions
            if (!isLoggedIn(request)) {
                response.sendRedirect("View/Signup.html");
                return;
            }



            switch (action) {

            case "showItems":
                showItems(request, response);
                break;

            case "showItem":
                showItem(request, response);
                break;

            case "addItem":
                addItem(request, response);
                break;

            case "deleteItem":
                deleteItem(request, response);
                break;

            case "updateItem":
                updateItem(request, response);
                break;

            default:
                showItems(request, response);
            }

        } catch (Exception e) {

            request.setAttribute("errorMessage", getErrorMessage(e));
            forward(request, response, "/View/Error.jsp");
        }
    }
    // ================= Helper Methods =================

    private ItemService getItemService() {
        return new ItemServiceImpl(dataSource);
    }

    private int getId(HttpServletRequest request) {
        return Integer.parseInt(request.getParameter("id"));
    }

    private Item getItemFromRequest(HttpServletRequest request) {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));

        return new Item(name, price, totalNumber);
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

    // ================= Controller Methods =================

    private void showItems(HttpServletRequest request, HttpServletResponse response) {

        List<Item> items = getItemService().getAllItem();

        request.setAttribute("allItems", items);

        forward(request, response, "/View/ShowItems.jsp");
    }

    private void showItem(HttpServletRequest request, HttpServletResponse response) {

        Item item = getItemService().getItemById(getId(request));

        request.setAttribute("SelectedItem", item);

        forward(request, response, "/View/UpdateItem.jsp");
    }

    private void addItem(HttpServletRequest request, HttpServletResponse response) {

        Item item = getItemFromRequest(request);

        if (getItemService().addItem(item)) {
            showItems(request, response);
        }
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response) {

        if (getItemService().removeItemById(getId(request))) {
            showItems(request, response);
        }
    }

    private void updateItem(HttpServletRequest request, HttpServletResponse response) {

        Item temp = getItemFromRequest(request);

        Item item = new Item(
                getId(request),
                temp.getName(),
                temp.getPrice(),
                temp.getTotalNumber());

        if (getItemService().updateItemById(item)) {
            showItems(request, response);
        }
    }
    
    
    public String getErrorMessage(Exception e) {

        Throwable cause = e.getCause();

        String message = (cause != null) ? cause.getMessage() : e.getMessage();

        if (message.contains("ORA-00001")) {
			return "Item name already exists.";
		}

        if (message.contains("ORA-02290")) {
			return "Price must be greater than 0 and Total Number cannot be negative.";
		}

        if (message.contains("ORA-01400")) {
			return "Required fields cannot be empty.";
		}

        if (message.contains("ORA-12899")) {
			return "Item name is too long.";
		}

        return "Unexpected database error.";
    }
    
    private boolean isLoggedIn(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return false;
        }

        UserService userService = new UserServiceImpl(dataSource);

        for (Cookie cookie : cookies) {

            if ("username".equals(cookie.getName())) {

                String username = cookie.getValue();

                if (username != null && !username.trim().isEmpty()) {
                    return userService.userExistsByUsername(username);
                }
            }
        }

        return false;
    }

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}