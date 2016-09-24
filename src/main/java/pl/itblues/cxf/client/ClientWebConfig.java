package pl.itblues.cxf.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.itblues.cxf.ws.api.FootballClub;

import static pl.itblues.cxf.ws.WsWebConfig.WS_ADDRESS;

/**
 * Created by Mikolaj Kania on 24.09.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("pl.itblues.cxf.client")
public class ClientWebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public JaxWsProxyFactoryBean jaxWsProxyFactoryBean() {
        JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
        proxyFactory.setServiceClass(FootballClub.class);
        proxyFactory.setAddress(WS_ADDRESS);
        return proxyFactory;
    }

    @Bean
    public FootballClub footballClubClient(JaxWsProxyFactoryBean jaxWsProxyFactoryBean) {
        return (FootballClub)jaxWsProxyFactoryBean.create();
    }

}
