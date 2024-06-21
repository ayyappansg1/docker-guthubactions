package common.Pojo;

public class TimeTrackingAdd {
    private boolean isCustomDate;
    private Object customDate;
    private Object policyId;
    private Object policyName;
    private String customerId;
    private String employeeId;

    public boolean getIsCustomDate() {
        return isCustomDate;
    }

    public void setIsCustomDate(boolean customDate) {
        isCustomDate = customDate;
    }

    public Object getCustomDate() {
        return customDate;
    }

    public void setCustomDate(Object customDate) {
        this.customDate = customDate;
    }

    public Object getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Object policyId) {
        this.policyId = policyId;
    }

    public Object getPolicyName() {
        return policyName;
    }

    public void setPolicyName(Object policyName) {
        this.policyName = policyName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
