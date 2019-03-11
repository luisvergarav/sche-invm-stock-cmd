package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.db.cosmos.StockRepository;

@Service
@Slf4j
public class StockService {

StockRepository repository;

public StockService(StockRepository repository) {
	super();
	this.repository = repository;
}

public boolean createStock(StockAggregate stockAgg){
	
	Stock stock = new Stock();
	stock.setSku(stockAgg.stockRootentity.getSku());
	stock.setAverageCost(stockAgg.stockRootentity.getAverageCost());
	stock.setPurchaseOrden(stockAgg.stockRootentity.getPurchaseOrden());
	stock.setStockAvailable(stockAgg.stockRootentity.getStockAvailable());
	stock.setStockOnLine(stockAgg.stockRootentity.getStockOnLine());
	stock.setStore(stockAgg.stockRootentity.getStore());
	stock.setTransferOrden(stockAgg.stockRootentity.getTransferOrden());
	this.repository.save(stock);
	log.info("Stock Saved successful ", stock);
	return true;
		
}

}
