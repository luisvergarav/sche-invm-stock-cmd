package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports;

import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.DomainEvent;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model.Stock;

public interface StockClient {



    Stock find( final String eventId );

	void save(DomainEvent domainEvent);

}
