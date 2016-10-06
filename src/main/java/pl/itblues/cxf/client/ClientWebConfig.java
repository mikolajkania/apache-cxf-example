package pl.itblues.cxf.client;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.itblues.cxf.ws.api.ClientConfig;

/**
 * Created by Mikolaj Kania on 06.10.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("pl.itblues.cxf.client")
@Import(ClientConfig.class)
public class ClientWebConfig {
}
