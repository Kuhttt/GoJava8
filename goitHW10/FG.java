public class FG {

    public void f() throws MySecondException {
        try {
            g();
        } catch (MyException e) {
            System.out.println("Handled first Exception");
            System.out.println(e);
            throw new MySecondException("My second exception");
        }
    }

    public void g() throws MyException {
        throw new MyException("My first exception");
    }
}
