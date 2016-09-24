package pl.itblues;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import pl.itblues.cxf.client.ClientWebConfig;
import pl.itblues.cxf.ws.WsWebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Mikolaj Kania on 24.09.2016.
 */
public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        wsDispatcher(servletContext);
        clientDispatcher(servletContext);
    }

    private void wsDispatcher(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(WsWebConfig.class);

        DispatcherServlet wsServlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("wsServlet", wsServlet);
        servlet.addMapping("/ws/");
        servlet.setLoadOnStartup(1);
    }

    private void clientDispatcher(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(ClientWebConfig.class);

        DispatcherServlet clientServlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("clientServlet", clientServlet);
        servlet.addMapping("/");
        servlet.setLoadOnStartup(2);
    }
}
