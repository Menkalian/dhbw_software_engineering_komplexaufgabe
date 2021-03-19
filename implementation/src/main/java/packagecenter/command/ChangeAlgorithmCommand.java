package packagecenter.command;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;
import packagecenter.parts.sortingsystem.tracks.sorting.SearchAlgorithm;
import packagecenter.parts.sortingsystem.tracks.sorting.SortingTrack;

public class ChangeAlgorithmCommand implements ICommand {
    private final SearchAlgorithm targetAlgorithm;

    public SearchAlgorithm getTargetAlgorithm() {
        return this.targetAlgorithm;
    }

    public ChangeAlgorithmCommand(SearchAlgorithm targetAlgorithm) {
        this.targetAlgorithm = targetAlgorithm;
    }

    public void execute(ICentralControlUnit controlUnit) {
        controlUnit
                .getPackageSortingCenter()
                .getSortingSystem()
                .getSortingTracks()
                .stream()
                .map(SortingTrack::getScanner)
                .forEach(s -> s.changeSearchAlgorithm(targetAlgorithm));
    }

    public CommandType getType() {
        return CommandType.CHANGE_ALGORITHM;
    }

}