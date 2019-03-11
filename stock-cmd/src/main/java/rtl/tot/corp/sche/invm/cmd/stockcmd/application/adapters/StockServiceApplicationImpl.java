package rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model.StockAggregate;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model.StockService;

@Service
public class StockServiceApplicationImpl {

	@Autowired
	StockService service;
	StockAggregate aggregate;

	public boolean addProduct(CreateStockCommandImpl cmd) {
		
		
		aggregate = new  StockAggregate.Builder()
				.sku(cmd.getSku())
				.averageCost(cmd.getAverageCost())
				.purchaseOrden(cmd.getPurchaseOrden())
				.stockAvailable(cmd.getStockAvailable())
				.stockOnLine(cmd.getStockOnLine())
				.store(cmd.getStore())
				.transferOrden(cmd.getTransferOrden())
				.build();
		if (this.aggregate.createStock(service))
			return true;
		else
			return false;

	}

}
