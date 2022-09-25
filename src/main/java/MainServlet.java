import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;import java.io.IOException;

@WebServlet(name = "GetProducts", urlPatterns = "/getproducts")
public class MainServlet implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(MainServlet.class);
    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        logger.info("New request: get products");
        for (int i = 0; i < 10; i++) {
            String title = "product" + (i+1);
            Product product = new Product(title, (float)Math.random()*1000);
            response.getWriter().printf("%d. %s: %.2f\n", product.getId(), product.getTitle(), product.getCost());

        }
        logger.info("End");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        logger.info("servlet is destroyed");
    }
}
