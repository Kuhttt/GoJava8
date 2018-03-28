public class Task04Main {

    public static void main(String[] args) {
        FG fg = new FG();
        try {
            fg.f();
        } catch (MySecondException e) {
            System.out.println("Handled second exception");
            System.out.println(e);
        }
    }
}
