package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

@Data
@EqualsAndHashCode( callSuper = true )
@ToString( callSuper = true )
@JsonPropertyOrder({ "eventType", "eventId", "occurredOn", "sku", "store","stockAvailable","stockOnLine","purchaseOrden","transferOrden","averageCost" })
public class StockUpdatedEvent extends DomainEvent {

	String  sku;
	Integer store;
	Float stockAvailable;
	Float stockOnLine;
	Float purchaseOrden;
	Float transferOrden;
	Float averageCost;

	@JsonCreator
	public StockUpdatedEvent(
			String eventId, 
			@JsonProperty( "occurredOn" ) Instant when, 
			String sku, 
			Integer store, 
			Float stockAvailable,
			Float stockOnLine, 
			Float purchaseOrden, 
			Float transferOrden, 
			Float averageCost) {
		super(eventId, when);
		this.sku = sku;
		this.store = store;
		this.stockAvailable = stockAvailable;
		this.stockOnLine = stockOnLine;
		this.purchaseOrden = purchaseOrden;
		this.transferOrden = transferOrden;
		this.averageCost = averageCost;

	}
    
   

 



	@Override

    public String eventType() {

        return this.getClass().getSimpleName();
    }

	

}
