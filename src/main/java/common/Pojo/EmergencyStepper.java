package common.Pojo;

public class EmergencyStepper {
    private String employeeId;
    private String contactFirstName;
    private String contactLastName;
    private int contactRelationship;
    private ContactHomePhone contactHomePhone;
    private ContactMobilePhone contactMobilePhone;
    private ContactWorkPhone contactWorkPhone;
    private ContactHomeAddress contactHomeAddress;
    private String contactEmail;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public int getContactRelationship() {
        return contactRelationship;
    }

    public void setContactRelationship(int contactRelationship) {
        this.contactRelationship = contactRelationship;
    }

    public ContactHomePhone getContactHomePhone() {
        return contactHomePhone;
    }

    public void setContactHomePhone(ContactHomePhone contactHomePhone) {
        this.contactHomePhone = contactHomePhone;
    }

    public ContactMobilePhone getContactMobilePhone() {
        return contactMobilePhone;
    }

    public void setContactMobilePhone(ContactMobilePhone contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone;
    }

    public ContactWorkPhone getContactWorkPhone() {
        return contactWorkPhone;
    }

    public void setContactWorkPhone(ContactWorkPhone contactWorkPhone) {
        this.contactWorkPhone = contactWorkPhone;
    }

    public ContactHomeAddress getContactHomeAddress() {
        return contactHomeAddress;
    }

    public void setContactHomeAddress(ContactHomeAddress contactHomeAddress) {
        this.contactHomeAddress = contactHomeAddress;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
