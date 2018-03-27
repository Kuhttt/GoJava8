public class idGenerator {

    static long uniqueId = 0;

    private idGenerator() {}

    public static long getUId(){
        ++uniqueId;
        return uniqueId;
    }

}
