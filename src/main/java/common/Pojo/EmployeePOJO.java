package common.Pojo;

public class EmployeePOJO {
    private String firstName;
    private String lastName;
    private String email;
    private String clientId;
    private String residenceCountry;
    private String workCountry;
    private String residenceCountryCode;
    private String workCountryCode;
    private String gender;
    private String employeeID;
    private String birthday;

    //get methods
    public String getEmployeeID()
    {
        return employeeID;
    }
    public String getGender()
    {
        return gender;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getClientId() {
        return clientId;
    }
    public String getResidenceCountry() {  return residenceCountry;     }
    public String getWorkCountry() {
        return workCountry;
    }
    public String getResidenceCountryCode() {  return residenceCountryCode; }
    public String getWorkCountryCode() { return workCountryCode;   }

    //set methods

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setClientId(String clientId) { this.clientId = clientId;    }
    public void setResidenceCountry(String residenceCountry) {
        this.residenceCountry = residenceCountry;
    }
    public void setWorkCountry(String workCountry) {
        this.workCountry = workCountry;
    }
    public void setResidenceCountryCode(String residenceCountryCode) { this.residenceCountryCode = residenceCountryCode;    }
    public void setWorkCountryCode(String workCountryCode) {  this.workCountryCode = workCountryCode;     }
}
