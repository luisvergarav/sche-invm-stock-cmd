package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model;


import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class StockRootEntity {

	
	
	public StockRootEntity(@NotNull String sku, @NotNull Integer store, @NotNull Float stockAvailable,
			@NotNull Float stockOnLine, @NotNull Float purchaseOrden, @NotNull Float transferOrden,
			@NotNull Float averageCost) {
		super();
		this.sku = sku;
		this.store = store;
		this.stockAvailable = stockAvailable;
		this.stockOnLine = stockOnLine;
		this.purchaseOrden = purchaseOrden;
		this.transferOrden = transferOrden;
		this.averageCost = averageCost;
	}
	@Id
	@NotNull
	String  sku;
	@NotNull
	Integer store;
	@NotNull
	Float stockAvailable;
	@NotNull
	Float stockOnLine;
	@NotNull
	Float purchaseOrden;
	@NotNull
	Float transferOrden;
	@NotNull
	Float averageCost;
	
	
	
}
