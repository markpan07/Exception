public class Main {
    public static void main(String[] args) {
        if(Checker.validate("mark01", "mTsdf00*", "mTsdf00*")) {
            System.out.println("You have access");
        } else {
            System.out.println("You have no access");
        }

    }
}