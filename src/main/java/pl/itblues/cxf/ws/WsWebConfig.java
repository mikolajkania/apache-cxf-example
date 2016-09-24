package pl.itblues.cxf.ws;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.xml.ws.Endpoint;

/**
 * Created by Mikolaj Kania on 24.09.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("pl.itblues.cxf.ws")
public class WsWebConfig extends WebMvcConfigurerAdapter {

    public static final String WS_ADDRESS = "http://localhost:8181/ws/footballclub";

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint(SpringBus springBus) {
        EndpointImpl endpoint = new EndpointImpl(springBus, new FootballClubImpl());
        endpoint.publish(WS_ADDRESS);
        return endpoint;
    }

}
