package ir.civilization.menu;

import ir.civilization.dto.CmdLoader;
import lombok.SneakyThrows;
import org.apache.commons.cli.CommandLine;

public abstract class AbstractMenuAction<D extends CmdLoader> {

    public abstract Class<D> getDtoClazz();

    public void takeAction(CommandLine commandLine) {
        D d = this.newInstance();
        d.loadFrom(commandLine);
        this.takeAction(d);
    }

    public abstract void takeAction(D d);

    @SneakyThrows
    private D newInstance() {
        return this.getDtoClazz().newInstance();
    }

}
