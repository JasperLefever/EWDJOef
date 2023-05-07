package controller;

import domein.BeerExpertBean;
import domein.BeerProperty;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Servlet", value = "/beerSelect")
public class BeerSelectServlet extends HttpServlet {
    private BeerExpertBean beerExpertBean = new BeerExpertBean();
    private BeerProperty beerProperty = new BeerProperty();


    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        context.setAttribute("beerColors", beerProperty.getColors());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("beerChoise.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("color");

        request.setAttribute("color", c);
        request.setAttribute("list", beerExpertBean.getBrands(c));
        RequestDispatcher view = request.getRequestDispatcher("beerResult.jsp");
        view.forward(request, response);
    }
}
