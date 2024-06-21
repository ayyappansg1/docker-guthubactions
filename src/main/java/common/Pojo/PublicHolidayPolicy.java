package common.Pojo;

import java.util.ArrayList;

public class PublicHolidayPolicy {
    private boolean isCustomEffectiveDate;
    private Object customEffectiveDate;
    private ArrayList<Object> holidayPolicies;

    public boolean getIsCustomEffectiveDate() {
        return isCustomEffectiveDate;
    }

    public void setIsCustomEffectiveDate(boolean customEffectiveDate) {
        isCustomEffectiveDate = customEffectiveDate;
    }

    public Object getCustomEffectiveDate() {
        return customEffectiveDate;
    }

    public void setCustomEffectiveDate(Object customEffectiveDate) {
        this.customEffectiveDate = customEffectiveDate;
    }

    public ArrayList<Object> getHolidayPolicies() {
        return holidayPolicies;
    }

    public void setHolidayPolicies(ArrayList<Object> holidayPolicies) {
        this.holidayPolicies = holidayPolicies;
    }
}
