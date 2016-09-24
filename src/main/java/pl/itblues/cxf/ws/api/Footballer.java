package pl.itblues.cxf.ws.api;

import lombok.*;

/**
 * Created by Mikolaj Kania on 24.09.2016.
 */
@NoArgsConstructor @Getter @Setter
public class Footballer {

    private String name;
    private int transferFee;
    private Agent agent;

    public Footballer(String name, int transferFee, Agent agent) {
        this.name = name;
        this.transferFee = transferFee;
        this.agent = agent;
    }
}
