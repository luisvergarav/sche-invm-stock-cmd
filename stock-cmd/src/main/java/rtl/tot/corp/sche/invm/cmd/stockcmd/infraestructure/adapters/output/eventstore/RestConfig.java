package rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.eventstore;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.DomainEvent;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.DomainEvents;

import java.util.UUID;

@Configuration
@org.springframework.cloud.netflix.feign.EnableFeignClients
public class RestConfig {

    @org.springframework.cloud.netflix.feign.FeignClient( value = "sche-invm-eventstore" /*, fallback = HystrixFallbackEventStoreClient.class */ )
    public interface EventStoreClient {

        @PostMapping( path = "/" )
        ResponseEntity addNewDomainEvent( @RequestBody DomainEvent event );

        @GetMapping( path = "/{sku}" )
        DomainEvents getDomainEventsForBoardUuid( @PathVariable( "sku" ) String sku );

    }

}