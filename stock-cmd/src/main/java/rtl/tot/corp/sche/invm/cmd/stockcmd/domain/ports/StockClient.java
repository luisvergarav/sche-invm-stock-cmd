package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports;

import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.DomainEvent;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.DomainEvents;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model.Stock;

public interface StockClient {



    DomainEvents find( final String sku ) throws Exception;

	void save(DomainEvent domainEvent) throws Exception;

	boolean check(String sku) throws Exception;

}
