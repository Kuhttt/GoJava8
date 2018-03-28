public class Task03NPE {

    public static void main(String[] args) {
        String str = null;
        try{
            System.out.println(str.length());
        }
        catch (NullPointerException e) {
            System.out.println("NPE has been handled!");
        }
    }
}
