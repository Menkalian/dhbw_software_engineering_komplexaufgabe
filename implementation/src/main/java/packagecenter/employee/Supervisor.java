package packagecenter.employee;

import packagecenter.employee.card.*;

public class Supervisor extends Employee {
    private boolean isSenior;

    public boolean isIsSenior() {
        return this.isSenior;
    }

    /**
     * 
     * @param id
     * @param name
     * @param idCard
     * @param isSenior
     */
    public Supervisor(int id, String name, IIDCard idCard, boolean isSenior) {
        super(id, name, idCard);
        // TODO - implement Supervisor.Supervisor @Löh
        throw new UnsupportedOperationException();
    }

}