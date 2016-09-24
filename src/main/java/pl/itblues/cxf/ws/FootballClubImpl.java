package pl.itblues.cxf.ws;

import pl.itblues.cxf.ws.api.FootballClub;
import pl.itblues.cxf.ws.api.Footballer;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Mikolaj Kania on 24.09.2016.
 */
@WebService(endpointInterface = "pl.itblues.cxf.ws.api.FootballClub")
public class FootballClubImpl implements FootballClub {

    @Override
    @WebMethod
    public String getName() {
        return "Liverpool FC";
    }

    @Override
    @WebMethod
    public String buy(Footballer footballer) {
        return "Bought " + footballer.getName() + " for " + footballer.getTransferFee() +
                "$ with help of " + footballer.getAgent();
    }
}
