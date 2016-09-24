package pl.itblues.cxf.ws.api;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Mikolaj Kania on 24.09.2016.
 */
@WebService
public interface FootballClub {

    @WebMethod
    String getName();

    @WebMethod
    String buy(Footballer footballer);
}
