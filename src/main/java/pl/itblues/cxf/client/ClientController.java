package pl.itblues.cxf.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itblues.cxf.ws.api.FootballClub;
import pl.itblues.cxf.ws.api.Footballer;
import pl.itblues.cxf.ws.api.Agent;

/**
 * Created by Mikolaj Kania on 24.09.2016.
 */
@RestController
public class ClientController {

    private final FootballClub footballClubClient;

    @Autowired
    public ClientController(FootballClub footballClubClient) {
        this.footballClubClient = footballClubClient;
    }

    @GetMapping(value = "/name")
    public String name() {
        return footballClubClient.getName();
    }

    @GetMapping(value = "/buy")
    public String buy() {
        return footballClubClient.buy(new Footballer("Ibra", 100_000_000, new Agent("Mino Raiola")));
    }
}
