package rtl.tot.corp.sche.invm.cmd.stockcmd.domain.ports;

public interface Handler<Command> {
public boolean handle(Command cmd) throws Exception;
}
