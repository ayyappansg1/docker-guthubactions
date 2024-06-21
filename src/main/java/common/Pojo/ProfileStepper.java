package common.Pojo;

import java.util.ArrayList;

public class ProfileStepper {
    private int title;
    private String firstName;
    private String lastName;
    private String preferredName;
    private String suffix;
    private String taxId;
    private int gender;
    private String birthday;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isLegallyAuthorized() {
        return isLegallyAuthorized;
    }

    public void setLegallyAuthorized(boolean legallyAuthorized) {
        isLegallyAuthorized = legallyAuthorized;
    }

    private int maritalStatus;

    private int ethnicity;
    private HomeAddress homeAddress;
    private Object isDualCitizen;
    private boolean isLegallyAuthorized;
    private ArrayList<Citizenship> citizenship;
    private ContactDetails contactDetails;
    private String employeeId;

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

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

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
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


    public int getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(int ethnicity) {
        this.ethnicity = ethnicity;
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

    public boolean getIsLegallyAuthorized() {
        return isLegallyAuthorized;
    }

    public void setIsLegallyAuthorized(boolean legallyAuthorized) {
        isLegallyAuthorized = legallyAuthorized;
    }

    public ArrayList<Citizenship> getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(ArrayList<Citizenship> citizenship) {
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
}
