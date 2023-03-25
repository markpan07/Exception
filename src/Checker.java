import java.util.Objects;

public class Checker {
    private static final String AVAILABLE_SYMBOLS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            System.out.println("Validation process has started");
            check(login, password, confirmPassword);
            return true;
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            System.out.println("Validation process has finished");
        }
    }

    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Login's length should contain up to 20 symbols");
        }
        if (Objects.isNull(password) || Objects.isNull(confirmPassword)) {
            throw new WrongPasswordException("Enter your password and confirm password");
        }
        if(!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password are not equal");
        }

        Checker checker = new Checker();
        if(!checker.checkSymbols(login)) {
            throw new WrongLoginException("Incorrect symbols in login");
        }
        if(!checker.checkSymbols(password)) {
            throw new WrongPasswordException("Incorrect symbols in password");
        }

    }

    private boolean checkSymbols(String s) {
        char[] chars = s.toCharArray();
        for (char symbol : chars) {
            if (!AVAILABLE_SYMBOLS.contains(Character.toString(symbol))) {
                return false;
            }
        }
        return true;

    }

}


