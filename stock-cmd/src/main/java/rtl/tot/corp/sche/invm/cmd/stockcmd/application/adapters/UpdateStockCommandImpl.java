package rtl.tot.corp.sche.invm.cmd.stockcmd.application.adapters;


import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.CreateStockCommand;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.http.rest.domain.StockUpdate;
@Data
public class UpdateStockCommandImpl implements CreateStockCommand<StockUpdate> {
	
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
	public UpdateStockCommandImpl(StockUpdate stock) {
		super();
		this.sku = stock.getSku();
		this.store = stock.getStore();
		this.stockAvailable = stock.getStockAvailable();
		this.stockOnLine = stock.getStockOnLine();
		this.purchaseOrden = stock.getPurchaseOrden();
		this.transferOrden = stock.getTransferOrden();
		this.averageCost = stock.getAverageCost();
	}



	
	

}