package rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.eventstore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model.EventStoreStockClient;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.StockClient;

@Configuration
public class EventStoreClientConfig {

    @Bean
    @Primary
    public StockClient boardClient(
 
            final RestConfig.EventStoreClient eventStoreClient
    ) {

        return new EventStoreStockClient( eventStoreClient );
    }

}
