package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class StockAggregate {

	final StockRootEntity  stockRootentity;
	
	public StockAggregate(Builder builder) {
		this.stockRootentity = new StockRootEntity(
				builder.sku,
				builder.store,
				builder.stockAvailable,
				builder.stockOnLine,
				builder.purchaseOrden,
				builder.transferOrden,
				builder.averageCost
				
				);
		
	}
	
	public boolean isValid() {
		return true;
	}
	
	
	public boolean createStock(StockService service) throws Exception {
		return service.createStock(this);
	}
	
	public boolean updateStock(StockService service) throws Exception {
		return service.updateStock(this);
	}
	
	public static class Builder{
	
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
		
		public StockAggregate build() {
			
			return new StockAggregate(this);
		}

		public Builder sku(String sku) {
			this.sku = sku;
			return this;
		}

		public Builder store(Integer store) {
			this.store = store;
			return this;
		}

		public Builder stockAvailable(Float stockAvailable) {
			this.stockAvailable = stockAvailable;
			return this;
		}

		public Builder stockOnLine(Float stockOnLine) {
			this.stockOnLine = stockOnLine;
			return this;
		}

		public Builder purchaseOrden(Float purchaseOrden) {
			this.purchaseOrden = purchaseOrden;
			return this;
		}

		public Builder transferOrden(Float transferOrden) {
			this.transferOrden = transferOrden;
			return this;
		}

		public Builder averageCost(Float averageCost) {
			this.averageCost = averageCost;
			return this;
		}
	



		
	}
}
