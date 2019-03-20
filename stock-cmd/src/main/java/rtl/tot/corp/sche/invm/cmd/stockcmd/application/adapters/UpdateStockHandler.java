package rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.Handler;

@Component
public class UpdateStockHandler implements Handler<UpdateStockCommandImpl>{

	@Autowired
	StockServiceApplicationImpl service;
	
	public UpdateStockHandler(StockServiceApplicationImpl service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(UpdateStockCommandImpl cmd) throws Exception {
		return service.updateStock((UpdateStockCommandImpl) cmd);
		
	}

}
