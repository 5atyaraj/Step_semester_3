class PasswordChecker {
    private final String password;

    // Constructor
    public PasswordChecker(String password) {
        this.password = password;
    }

    // Return only password strength
    public String getStrength() {
        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class P3_ThePasswordChecker {
    public static void main(String[] args) {

        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Password 1 Strength: " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Password 2 Strength: " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("Password 3 Strength: " + pc3.getStrength());

        PasswordChecker pc4 = new PasswordChecker("abcdefghijkl");
        System.out.println("Password 4 Strength: " + pc4.getStrength());
    }
}