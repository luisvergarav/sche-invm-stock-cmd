package rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters;


import org.springframework.stereotype.Component;

import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.CommandBus;

@Component
public class CreateStockCommandBus implements CommandBus<CreateStockCommandImpl> {

	
	CreateStockHandler handler;

	public CreateStockCommandBus(CreateStockHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(CreateStockCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}