package rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.Handler;

@Component
public class CreateStockHandler implements Handler<CreateStockCommandImpl>{

	@Autowired
	StockServiceApplicationImpl service;
	
	public CreateStockHandler(StockServiceApplicationImpl service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(CreateStockCommandImpl cmd) throws Exception {
		return service.addProduct((CreateStockCommandImpl) cmd);
		
	}

}
