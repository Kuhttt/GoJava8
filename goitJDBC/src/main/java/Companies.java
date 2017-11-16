public class Companies {

    private int compId;
    private String compName;

    public Companies(int compId, String compName) {
        this.compId = compId;
        this.compName = compName;
    }

    public Companies() {
    }

    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "compId=" + compId +
                ", compName='" + compName + '\'' +
                '}';
    }
}
