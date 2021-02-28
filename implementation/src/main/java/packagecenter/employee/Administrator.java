package packagecenter.employee;

import packagecenter.employee.card.*;

public class Administrator extends Employee {
    private AdministratorProfile profile;

    public AdministratorProfile getProfile() {
        return this.profile;
    }

    /**
     * 
     * @param id
     * @param name
     * @param idCard
     * @param profile
     */
    public Administrator(int id, String name, IIDCard idCard, AdministratorProfile profile) {
        super(id, name, idCard);
        // TODO - implement Administrator.Administrator @Löh
        throw new UnsupportedOperationException();
    }

}