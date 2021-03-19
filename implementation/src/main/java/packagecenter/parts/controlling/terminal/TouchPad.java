package packagecenter.parts.controlling.terminal;

import packagecenter.command.*;
import packagecenter.parts.sortingsystem.tracks.sorting.SearchAlgorithm;

public class TouchPad implements ITouchPad {
    private final ITerminal terminal;

    public void init() {
        terminal.sendCommand(new InitCommand());
    }

    public void next() {
        terminal.sendCommand(new NextCommand());
    }

    public void shutdown() {
        terminal.sendCommand(new ShutdownCommand());
    }

    public void lock() {
        terminal.sendCommand(new LockCommand());
    }

    public void unlock() {
        terminal.sendCommand(new UnlockCommand());
    }

    public void showStatistics() {
        terminal.sendCommand(new ShowStatisticsCommand());
    }

    public void changeAlgorithm(SearchAlgorithm algorithm) {
        terminal.sendCommand(new ChangeAlgorithmCommand(algorithm));
    }

    public TouchPad(ITerminal terminal) {
        this.terminal = terminal;
    }

}