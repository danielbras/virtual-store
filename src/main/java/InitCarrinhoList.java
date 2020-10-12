import Utils.Carrinho;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class InitCarrinhoList implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public InitCarrinhoList() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        List<Carrinho> carrinhoList = new ArrayList<>();

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("carrinho", carrinhoList);

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }
}
