package rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.CommandBus;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.asb.EventPublisherService;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.asb.EventType;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.asb.StockCreatedIntegrationEvent;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.asb.StockUpdatedIntegrationEvent;
@Slf4j
@Component
public class DecoratorUpdateStockCommandBus implements CommandBus<UpdateStockCommandImpl> {
	

	@Autowired
	EventPublisherService publisher;
	UpdateStockCommandBus bus;
	
    public DecoratorUpdateStockCommandBus(UpdateStockCommandBus bus) {
    	this.bus = bus;
    }
    

    	@Override
	public boolean execute(UpdateStockCommandImpl command) throws Exception {

	        StockUpdatedIntegrationEvent integrationEvent = null;
    		try{
    			
    	       
    	        
    	        integrationEvent = new StockUpdatedIntegrationEvent();
    	        
    	       integrationEvent.setAverageCost(command.getAverageCost());
    	       integrationEvent.setPurchaseOrden(command.getPurchaseOrden());
    	       integrationEvent.setSku(command.getSku());
    	       integrationEvent.setStockAvailable(command.getStockAvailable());
    	       integrationEvent.setStockOnLine(command.getStockOnLine());
    	       integrationEvent.setStore(command.getStore());
    	       integrationEvent.setTransferOrden(command.getTransferOrden());
    	
    	        if  (this.bus.execute(command)) {
    	            log.info("Sending StockUpdateEvent integration Event " , command.getSku());
    	       	 
    	        	return publisher.publish(EventType.STOCK_UPDATED, integrationEvent);
    				   	        
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending StockUpdateEvent integration Event " + integrationEvent.getMetadata() , e.getLocalizedMessage());
    		}

    		
    	
		
		return false;
	}


	}