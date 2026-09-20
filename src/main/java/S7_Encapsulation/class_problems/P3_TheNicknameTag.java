class NameTag {
    private final String firstName;
    private final String lastName;

    // Constructor
    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");

        firstName = parts[0];
        lastName = parts[1];
    }

    // Get nickname
    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}
public class P3_TheNicknameTag  {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}
