package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Item;
import model.ItemDetails;
import service.ItemDetailsService;
import service.ItemService;
import service.impl.ItemDetailsServiceImpl;
import service.impl.ItemServiceImpl;

@WebServlet("/ItemDetailsController")
public class ItemDetailsController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Resource(name = "hamada")
    private DataSource dataSource;

    //==========================================================
    // Main Methods
    //==========================================================

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String action = request.getParameter("action");

            if (action == null) {
                redirectToItems(response, request);
                return;
            }

            switch (action) {

            case "addDetails":
                addDetails(request, response);
                break;

            case "showDetails":
                showDetails(request, response);
                break;

            case "updateDetails":
                updateDetails(request, response);
                break;

            case "deleteDetails":
                deleteDetails(request, response);
                break;

            default:
                redirectToItems(response, request);
            }

        } catch (Exception e) {

            request.setAttribute("errorMessage", e.getMessage());
            forward(request, response, "/View/Error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    //==========================================================
    // Helper Methods
    //==========================================================

    private ItemDetailsService getItemDetailsService() {

        return new ItemDetailsServiceImpl(dataSource);
    }

    private ItemService getItemService() {

        return new ItemServiceImpl(dataSource);
    }

    private ItemDetails buildItemDetails(HttpServletRequest request) {

        int itemId = Integer.parseInt(request.getParameter("itemId"));

        Item item = getItemService().getItemById(itemId);

        String description = request.getParameter("description");

        int warrantyMonths =
                Integer.parseInt(request.getParameter("warrantyMonths"));

        return new ItemDetails(item, description, warrantyMonths);
    }

    private void redirectToItems(HttpServletResponse response,
            HttpServletRequest request) throws IOException {

        response.sendRedirect(
                request.getContextPath()
                        + "/ItemController?action=showItems");
    }

    private void forward(HttpServletRequest request,
            HttpServletResponse response,
            String page)
            throws ServletException, IOException {

        request.getRequestDispatcher(page).forward(request, response);
    }

    //==========================================================
    // CRUD Methods
    //==========================================================

    private void addDetails(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        ItemDetails itemDetails = buildItemDetails(request);

        boolean added =
                getItemDetailsService().addItemDetails(itemDetails);

        if (added) {
            redirectToItems(response, request);
        }
    }

    private void showDetails(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int itemId = Integer.parseInt(request.getParameter("id"));

        ItemDetails itemDetails =
                getItemDetailsService().getItemDetailsByItemId(itemId);

        request.setAttribute("SelecteditemDetails", itemDetails);

        forward(request, response, "/View/UpdateDetails.jsp");
    }

    private void updateDetails(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        ItemDetails itemDetails = buildItemDetails(request);

        boolean updated =
                getItemDetailsService().updateItemDetails(itemDetails);

        if (updated) {
            redirectToItems(response, request);
        }
    }

    private void deleteDetails(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int itemId = Integer.parseInt(request.getParameter("id"));

        boolean deleted =
                getItemDetailsService()
                        .removeItemDetailsByItemId(itemId);

        if (deleted) {
            redirectToItems(response, request);
        }
    }

}