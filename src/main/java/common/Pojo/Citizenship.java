package common.Pojo;

import java.util.ArrayList;

public class Citizenship {
    private String nationalId;
    private ArrayList<String> nationalIds;
    private String country;
    private String countryCode;

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public ArrayList<String> getNationalIds() {
        return nationalIds;
    }

    public void setNationalIds(ArrayList<String> nationalIds) {
        this.nationalIds = nationalIds;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
