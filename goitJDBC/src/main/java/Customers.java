public class Customers {

    private int custId;
    private String custName;

    public Customers(int custId, String custName) {
        this.custId = custId;
        this.custName = custName;
    }

    public Customers() {
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                '}';
    }
}
