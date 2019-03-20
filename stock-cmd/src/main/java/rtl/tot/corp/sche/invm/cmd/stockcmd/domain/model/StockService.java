package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.DomainEvent;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.DomainEvents;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.StockCreatedEvent;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.StockUpdatedEvent;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.StockClient;

@Service
@Slf4j
public class StockService {

	private StockClient client ;

    public StockService( final StockClient client ) {

        this.client = client;

    }

public boolean createStock(StockAggregate stockAgg) throws Exception{
	StockCreatedEvent domainEvent = new StockCreatedEvent(
	UUID.randomUUID().toString(),
	Instant.now(),		
	stockAgg.stockRootentity.getSku(),
	stockAgg.stockRootentity.getStore(),
	stockAgg.stockRootentity.getStockAvailable(),
	stockAgg.stockRootentity.getStockOnLine(),
	stockAgg.stockRootentity.getPurchaseOrden(),
	stockAgg.stockRootentity.getTransferOrden(),
	stockAgg.stockRootentity.getAverageCost()
);

	client.save(domainEvent);
	log.info("Stock Event Saved successful ", stockAgg.stockRootentity.getSku());

	return true;
		
}

public boolean updateStock(StockAggregate stockAgg) throws Exception{
	StockUpdatedEvent domainEvent = new StockUpdatedEvent(
	UUID.randomUUID().toString(),
	Instant.now(),		
	stockAgg.stockRootentity.getSku(),
	stockAgg.stockRootentity.getStore(),
	stockAgg.stockRootentity.getStockAvailable(),
	stockAgg.stockRootentity.getStockOnLine(),
	stockAgg.stockRootentity.getPurchaseOrden(),
	stockAgg.stockRootentity.getTransferOrden(),
	stockAgg.stockRootentity.getAverageCost()
);
	if (client.check(stockAgg.stockRootentity.getSku())) {
		client.save(domainEvent);
		log.info("Stock Event Saved successful ", stockAgg.stockRootentity.getSku());	
		return true;
	}
	else
		return false;
		
}

private StockAggregate aggregateFromEvents(DomainEvents events) {
	for (DomainEvent event : events.getDomainEvents()) {
		//StockAggregate agg  = new StockAggregate.Builder()
				
		//		);
	}
	return null;
}

}
