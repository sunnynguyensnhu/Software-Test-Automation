package contactapp;

// Contact class for storing a person's info in the app
public class Contact {
    private final String contactID;  // Can't change after it's set
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Main constructor - does all validation right away
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("contactID must be non-null, max 10 chars");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("firstName must be non-null, max 10 chars");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("lastName must be non-null, max 10 chars");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("phone must be non-null and exactly 10 digits");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("address must be non-null, max 30 chars");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactID() {
        return contactID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    // Setters
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("firstName must be non-null, max 10 chars");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("lastName must be non-null, max 10 chars");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("phone must be non-null and exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("address must be non-null, max 30 chars");
        }
        this.address = address;
    }

    // toString - helpful for printing contact info (optional)
    @Override
    public String toString() {
        return "Contact{" +
                "contactID='" + contactID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // equals - used in tests to compare two Contact objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return contactID.equals(contact.contactID);
    }
}
