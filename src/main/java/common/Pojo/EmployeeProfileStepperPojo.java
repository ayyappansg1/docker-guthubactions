package common.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class EmployeeProfileStepperPojo {
    private String firstName;
    private String lastName;
    private String taxId;
    private int gender;
    private String birthday;
    private Object maritalStatus;
    private Object preferredName;
    private Object suffix;
    private Object title;
    private HomeAddress homeAddress;
    private Object isDualCitizen;
    private Object isLegallyAuthorized;
    private ArrayList<Object> citizenship;
    private ContactDetails contactDetails;
    private String employeeId;
    private int users;
    private int wseClassification;
    @JsonProperty("Pronoun")
    private Pronoun pronoun;
    private EmployeeVerification employeeVerification;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Object getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Object maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Object getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(Object preferredName) {
        this.preferredName = preferredName;
    }

    public Object getSuffix() {
        return suffix;
    }

    public void setSuffix(Object suffix) {
        this.suffix = suffix;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Object getIsDualCitizen() {
        return isDualCitizen;
    }

    public void setIsDualCitizen(Object isDualCitizen) {
        this.isDualCitizen = isDualCitizen;
    }

    public Object getIsLegallyAuthorized() {
        return isLegallyAuthorized;
    }

    public void setIsLegallyAuthorized(Object isLegallyAuthorized) {
        this.isLegallyAuthorized = isLegallyAuthorized;
    }

    public ArrayList<Object> getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(ArrayList<Object> citizenship) {
        this.citizenship = citizenship;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getWseClassification() {
        return wseClassification;
    }

    public void setWseClassification(int wseClassification) {
        this.wseClassification = wseClassification;
    }

    public Pronoun getPronoun() {
        return pronoun;
    }

    public void setPronoun(Pronoun pronoun) {
        this.pronoun = pronoun;
    }

    public EmployeeVerification getEmployeeVerification() {
        return employeeVerification;
    }

    public void setEmployeeVerification(EmployeeVerification employeeVerification) {
        this.employeeVerification = employeeVerification;
    }
}
