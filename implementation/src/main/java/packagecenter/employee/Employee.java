package packagecenter.employee;

import packagecenter.employee.card.*;

public abstract class Employee {
    protected int id;
    protected String name;
    protected IIDCard idCard;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 
     * @param id
     * @param name
     * @param idCard
     */
    public Employee(int id, String name, IIDCard idCard) {
        // TODO - implement Employee.Employee @Löh
        throw new UnsupportedOperationException();
    }

}