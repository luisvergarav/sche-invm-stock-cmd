package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class DomainEvents {

    private String sku;
    private List<DomainEvent> domainEvents = new ArrayList<>();

}
