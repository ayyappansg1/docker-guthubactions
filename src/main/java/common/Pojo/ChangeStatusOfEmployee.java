package common.Pojo;

public class ChangeStatusOfEmployee {
    private String employeeId;
    private String effectiveDate;
    private int newStatus;
    private String comments;
    private String atlasStartDate;
    private int currentStatus;

    public int getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(int currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public int getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(int newStatus) {
        this.newStatus = newStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAtlasStartDate() {
        return atlasStartDate;
    }

    public void setAtlasStartDate(String atlasStartDate) {
        this.atlasStartDate = atlasStartDate;
    }
}
