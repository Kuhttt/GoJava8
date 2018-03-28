public class Task01MainWithExceptions {

    public static void main(String[] args) {
        //1
        try {
            throw new Exception("Exception happened!");
        }
        catch (Exception e) {
            System.err.println(e);
        }
        finally {
            System.out.println("Final block");
        }
    }
}
