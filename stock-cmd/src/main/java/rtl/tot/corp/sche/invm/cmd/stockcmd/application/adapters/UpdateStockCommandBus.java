package rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters;


import org.springframework.stereotype.Component;

import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.CommandBus;

@Component
public class UpdateStockCommandBus implements CommandBus<UpdateStockCommandImpl> {

	
	UpdateStockHandler handler;

	public UpdateStockCommandBus(UpdateStockHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(UpdateStockCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}