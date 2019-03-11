package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.events;

public enum EventType {
    STOCK_CREATED("stockCreated"),
    STOCK_UPDATED("stockUpdated");

    private final String name;

    EventType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

