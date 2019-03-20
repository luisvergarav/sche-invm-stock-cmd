package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

import static lombok.AccessLevel.NONE;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "eventType"
)
@JsonSubTypes({
        @JsonSubTypes.Type( value = StockCreatedEvent.class, name = "StockCreatedEvent" )
  

})
@Data
public abstract class DomainEvent {

    private final String eventId;

    @Getter( NONE )
    @JsonIgnore
    private final Instant when;

    DomainEvent( final String eventId, final Instant when ) {

        this.eventId = eventId;
        this.when = when;

    }

    @JsonProperty( "occurredOn" )
    public Instant occurredOn() {

        return when;
    }

    @JsonProperty( "eventType" )
    public abstract String eventType();

}
