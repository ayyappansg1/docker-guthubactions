package common.Pojo;

import java.util.ArrayList;

public class TimeoffStepper {
    private String employeeId;
    private PublicHolidayPolicy publicHolidayPolicy;
    private ArrayList<TimeOffPolicy> timeOffPolicies;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public PublicHolidayPolicy getPublicHolidayPolicy() {
        return publicHolidayPolicy;
    }

    public void setPublicHolidayPolicy(PublicHolidayPolicy publicHolidayPolicy) {
        this.publicHolidayPolicy = publicHolidayPolicy;
    }

    public ArrayList<TimeOffPolicy> getTimeOffPolicies() {
        return timeOffPolicies;
    }

    public void setTimeOffPolicies(ArrayList<TimeOffPolicy> timeOffPolicies) {
        this.timeOffPolicies = timeOffPolicies;
    }
}
