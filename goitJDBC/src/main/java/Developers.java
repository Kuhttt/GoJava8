public class Developers {

    private int devId;
    private String devName;

    public Developers(int devId, String devName) {
        this.devId = devId;
        this.devName = devName;
    }

    public Developers() {
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "devId=" + devId +
                ", devName='" + devName + '\'' +
                '}';
    }
}
