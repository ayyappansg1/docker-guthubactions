package common.Pojo;

public class TimeOffPolicy {
    private String policyId;
    private String policyName;
    private Object policyAssignmentDate;
    private String customEffectiveDate;
    private String timeOffType;
    private boolean isCustomEffectiveDate;
    private String timeOffTypeId;
    private String timeOffTypeName;

    public boolean isCustomEffectiveDate() {
        return isCustomEffectiveDate;
    }

    public void setCustomEffectiveDate(boolean customEffectiveDate) {
        isCustomEffectiveDate = customEffectiveDate;
    }

    public String getTimeOffTypeId() {
        return timeOffTypeId;
    }

    public void setTimeOffTypeId(String timeOffTypeId) {
        this.timeOffTypeId = timeOffTypeId;
    }

    public String getTimeOffTypeName() {
        return timeOffTypeName;
    }

    public void setTimeOffTypeName(String timeOffTypeName) {
        this.timeOffTypeName = timeOffTypeName;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Object getPolicyAssignmentDate() {
        return policyAssignmentDate;
    }

    public void setPolicyAssignmentDate(Object policyAssignmentDate) {
        this.policyAssignmentDate = policyAssignmentDate;
    }

    public String getCustomEffectiveDate() {
        return customEffectiveDate;
    }

    public void setCustomEffectiveDate(String customEffectiveDate) {
        this.customEffectiveDate = customEffectiveDate;
    }

    public String getTimeOffType() {
        return timeOffType;
    }

    public void setTimeOffType(String timeOffType) {
        this.timeOffType = timeOffType;
    }

    public boolean getIsCustomEffectiveDate() {
        return isCustomEffectiveDate;
    }

    public void setIsCustomEffectiveDate(boolean customEffectiveDate) {
        isCustomEffectiveDate = customEffectiveDate;
    }
}
