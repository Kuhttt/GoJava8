public class Task02OwnExceptionClass {

    public static void main(String[] args) {
        try{
            throw new MyException("MyException has been thrown!");
        }
        catch (MyException e) {
            System.out.println(e);
        }
        finally {
            System.out.println("Final block");
        }
    }
}
