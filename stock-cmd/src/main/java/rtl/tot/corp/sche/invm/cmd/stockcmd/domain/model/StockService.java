package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.StockCreatedEvent;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.StockClient;

@Service
@Slf4j
public class StockService {

	private StockClient client ;

    public StockService( final StockClient client ) {

        this.client = client;

    }

public boolean createStock(StockAggregate stockAgg){
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
//	Stock stock = new Stock();
//	
//	stock.setSku(stockAgg.stockRootentity.getSku());
//	stock.setAverageCost(stockAgg.stockRootentity.getAverageCost());
//	stock.setPurchaseOrden(stockAgg.stockRootentity.getPurchaseOrden());
//	stock.setStockAvailable(stockAgg.stockRootentity.getStockAvailable());
//	stock.setStockOnLine(stockAgg.stockRootentity.getStockOnLine());
//	stock.setStore(stockAgg.stockRootentity.getStore());
//	stock.setTransferOrden(stockAgg.stockRootentity.getTransferOrden());
	//this.repository.save(stock);
	client.save(domainEvent);
	log.info("Stock Event Saved successful ", stockAgg.stockRootentity.getSku());

	return true;
		
}


}
