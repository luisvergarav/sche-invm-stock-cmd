package rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.CommandBus;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.asb.EventPublisherService;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.asb.EventType;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.asb.StockCreatedIntegrationEvent;
@Slf4j
@Component
public class DecoratorCreateStockCommandBus implements CommandBus<CreateStockCommandImpl> {
	

	@Autowired
	EventPublisherService publisher;
	CreateStockCommandBus bus;
	
    public DecoratorCreateStockCommandBus(CreateStockCommandBus bus) {
    	this.bus = bus;
    }
    

    	@Override
	public boolean execute(CreateStockCommandImpl command) throws Exception {

	        StockCreatedIntegrationEvent integrationEvent = null;
    		try{
    			
    	       
    	        
    	        integrationEvent = new StockCreatedIntegrationEvent();
    	        
    	       integrationEvent.setAverageCost(command.getAverageCost());
    	       integrationEvent.setPurchaseOrden(command.getPurchaseOrden());
    	       integrationEvent.setSku(command.getSku());
    	       integrationEvent.setStockAvailable(command.getStockAvailable());
    	       integrationEvent.setStockOnLine(command.getStockOnLine());
    	       integrationEvent.setStore(command.getStore());
    	       integrationEvent.setTransferOrden(command.getTransferOrden());
    	
    	        if  (this.bus.execute(command)) {
    	            log.info("Sending StockCreateEvent integration Event " , command.getSku());
    	       	 
    	        	return publisher.publish(EventType.STOCK_CREATED, integrationEvent);
    				   	        
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending StockCreateEvent integration Event " + integrationEvent.getMetadata() , e);
    		}

    		
    	
		
		return false;
	}


	}