public class Task05Main {

    public static void main(String[] args) {
        ThrowingClass t = new ThrowingClass();

        for (int i = 0; i < 3; i++) {
            try {
                t.dosomething(i);
            }
            catch (Exception e) {
                System.out.println("Exception " + e + " handled");
            }
        }
    }
}
