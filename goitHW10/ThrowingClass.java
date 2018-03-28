public class ThrowingClass {

    public void dosomething(int i) throws MySecondException, MyThirdException, MyException {
        switch (i) {
            case 0:
                throw new MyException("First");
            case 1:
                throw new MySecondException("Second");
            default:
                throw new MyThirdException("Third");
        }
    }
}
