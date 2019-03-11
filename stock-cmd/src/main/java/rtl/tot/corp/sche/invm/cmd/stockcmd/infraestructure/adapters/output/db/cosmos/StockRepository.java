package rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.db.cosmos;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model.Stock;


@Repository
public interface StockRepository extends DocumentDbRepository<Stock, Long> {
 
}
