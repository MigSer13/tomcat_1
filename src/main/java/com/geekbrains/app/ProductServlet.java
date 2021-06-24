package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// http://localhost:8081/client/Products
public class ProductServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> productsList = new ArrayList<>();
        productsList.add("Яблоко");
        productsList.add("Хлеб");
        productsList.add("Батон");
        productsList.add("Огурец");
        productsList.add("Помидор");
        productsList.add("Колбаса");
        productsList.add("Сыр");
        productsList.add("Банан");
        productsList.add("Молоко");
        productsList.add("Чай");
        resp.getWriter().printf("<html><body>");
        for (int i = 1; i <= 10; i++) {
            new Product(i, productsList.get((int)(Math.random()*10)), (int) (Math.random()*100));
            resp.getWriter().print(""+i+" - "+productsList.get((int)(Math.random()*10)) + ", "+(int)(Math.random()*100) + "руб.");
            //resp.getWriter().print("<h1>"+i+"</h1>");

        }
        resp.getWriter().printf("</body></html>");
    }

    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}
