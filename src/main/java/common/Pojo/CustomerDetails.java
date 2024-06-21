package common.Pojo;

public class CustomerDetails {

    private String id;
    private String name;
    private Object region;
    private Object statusLabel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getRegion() {
        return region;
    }

    public void setRegion(Object region) {
        this.region = region;
    }

    public Object getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(Object statusLabel) {
        this.statusLabel = statusLabel;
    }
}
