package common.Pojo;

import java.util.ArrayList;
import java.util.List;

public class CompensationDetails {
    private String lppId;
    private String currency;
    private int payType;
    private Object paymentSchedule;
    private int amount;
    private Object isOvertimeApplicable;
    private int totalHours;
    private Object additionalMonthlyInstallmentsRequired;
    private List<Object> additionalMonthlyInstallments = new ArrayList<>();
    public Object getAdditionalMonthlyInstallmentsRequired() {
        return additionalMonthlyInstallmentsRequired;
    }

    public List<Object> getAdditionalMonthlyInstallments() {
        return additionalMonthlyInstallments;
    }

    public void setAdditionalMonthlyInstallments() {
        this.additionalMonthlyInstallments = additionalMonthlyInstallments;
    }

    public void setAdditionalMonthlyInstallmentsRequired(Object additionalMonthlyInstallmentsRequired) {
        this.additionalMonthlyInstallmentsRequired = additionalMonthlyInstallmentsRequired;
    }

    public String getAdditionalMonthlyInstallmentsDescription() {
        return additionalMonthlyInstallmentsDescription;
    }

    public void setAdditionalMonthlyInstallmentsDescription(String additionalMonthlyInstallmentsDescription) {
        this.additionalMonthlyInstallmentsDescription = additionalMonthlyInstallmentsDescription;
    }

    private String additionalMonthlyInstallmentsDescription;

    public String getLppId() {
        return lppId;
    }

    public void setLppId(String lppId) {
        this.lppId = lppId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public Object getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(Object paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Object getIsOvertimeApplicable() {
        return isOvertimeApplicable;
    }

    public void setIsOvertimeApplicable(Object isOvertimeApplicable) {
        this.isOvertimeApplicable = isOvertimeApplicable;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }
}
