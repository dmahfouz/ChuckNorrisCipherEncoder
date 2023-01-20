
class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        this.firstName = firstName == null ? this.firstName : firstName;
    }

    public void setLastName(String lastName) {
        // write your code here
        this.lastName = lastName == null ? this.lastName : lastName;
    }

    public String getFullName() {
        String fullName = (firstName + " " + lastName).trim();
        return fullName.equals("") ? "Unknown" : fullName;
    }
}