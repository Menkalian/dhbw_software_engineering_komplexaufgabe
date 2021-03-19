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

    public IIDCard getIdCard(){
        return idCard;
    }

    public void setIdCard(IIDCard idCard) {
        this.idCard = idCard;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

}