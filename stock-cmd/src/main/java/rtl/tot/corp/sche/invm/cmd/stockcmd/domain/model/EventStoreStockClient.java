package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.model;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.DomainEvent;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events.DomainEvents;
import rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports.StockClient;
import rtl.tot.corp.sche.invm.cmd.stockcmd.infraestructure.adapters.output.eventstore.RestConfig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Slf4j
public class EventStoreStockClient implements StockClient {

    private final RestConfig.EventStoreClient eventStoreClient;

    public EventStoreStockClient( final RestConfig.EventStoreClient eventStoreClient ) {

        this.eventStoreClient = eventStoreClient;

    }

    @Override
    //@HystrixCommand
    public void save( final DomainEvent domainEvent ) {
        
        
        log.debug( "save : domainEvent=" + domainEvent );

        ResponseEntity accepted = this.eventStoreClient.addNewDomainEvent( domainEvent );
        if( !accepted.getStatusCode().equals( HttpStatus.ACCEPTED ) ) {

            throw new IllegalStateException( "could not add DomainEvent to the Event Store" );
        }
    
   

    log.debug( "save : exit" );
}

    @Override
    //@HystrixCommand
    public Stock find( final String boardUuid ) {
        log.debug( "find : enter" );

        DomainEvents domainEvents = this.eventStoreClient.getDomainEventsForBoardUuid( boardUuid );
        if( domainEvents.getDomainEvents().isEmpty() ) {

            log.warn( "find : exit, target[" + boardUuid.toString() + "] not found" );
            throw new IllegalArgumentException( "board[" + boardUuid.toString() + "] not found" );
        }

        //Board board = Board.createFrom( boardUuid, domainEvents.getDomainEvents() );
        //board.flushChanges();

        log.debug( "find : exit" );
        return null;
    }

}
