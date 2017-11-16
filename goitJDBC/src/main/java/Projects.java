public class Projects {

    private int projId;
    private String projName;

    public Projects(int projId, String projName) {
        this.projId = projId;
        this.projName = projName;
    }

    public Projects() {
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "projId=" + projId +
                ", projName=" + projName +
                '}';
    }
}
