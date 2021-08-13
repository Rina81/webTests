package webTests.model;

public class ContactData {
    private final String firstName;
    private final String lastname;
    private final String nickname;
    private final String mobile;
    private final String email;

    public ContactData(String firstName, String lastname, String nickname, String mobile, String email) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.nickname = nickname;
        this.mobile = mobile;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}
