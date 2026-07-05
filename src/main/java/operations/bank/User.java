package operations.bank;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String streetName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private long idNumber;

    // Constructor (for new users before database insert)
    public User(String firstName, String lastName, String streetName, 
                int birthDay, int birthMonth, int birthYear, long idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetName = streetName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.idNumber = idNumber;
    }

    // Getters/Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getStreetName() { return streetName; }
    public void setStreetName(String streetName) { this.streetName = streetName; }

    public int getBirthDay() { return birthDay; }
    public void setBirthDay(int birthDay) { this.birthDay = birthDay; }

    public int getBirthMonth() { return birthMonth; }
    public void setBirthMonth(int birthMonth) { this.birthMonth = birthMonth; }

    public int getBirthYear() { return birthYear; }
    public void setBirthYear(int birthYear) { this.birthYear = birthYear; }

    public long getIdNumber() { return idNumber; }
    public void setIdNumber(long idNumber) { this.idNumber = idNumber; }

    @Override
    public String toString() {
        return String.format("User{id=%d, name=%s %s, dob=%d-%02d-%02d, idNum=%d}", 
            id, firstName, lastName, birthYear, birthMonth, birthDay, idNumber);
    }
}
