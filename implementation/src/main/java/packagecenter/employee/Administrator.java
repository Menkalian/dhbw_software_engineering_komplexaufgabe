package packagecenter.employee;

import packagecenter.employee.card.*;

public class Administrator extends Employee {
    private final AdministratorProfile profile;

    public AdministratorProfile getProfile() {
        return this.profile;
    }

    public Administrator(int id, String name, AdministratorProfile profile) {
        super(id, name);
        this.profile = profile;
    }

}