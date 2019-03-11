package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports;

public interface CommandBus<Command> {

    public boolean execute(Command command) throws Exception;
}