package contactapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests for the Contact class
public class ContactTest {

    @Test
    public void testContactCreationValid() {
        Contact contact = new Contact("1234567890", "Alessia", "Mori", "5551234567", "4829 Willow Creek Dr, Apt 11F");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("Alessia", contact.getFirstName());
        assertEquals("Mori", contact.getLastName());
        assertEquals("5551234567", contact.getPhone());
        assertEquals("4829 Willow Creek Dr, Apt 11F", contact.getAddress());
    }

    @Test
    public void testContactCreationMaxLength() {
        Contact contact = new Contact("abcdefghij", "PriyaDesai", "AlHassan", "0123456789", "123456789012345678901234567890");
        assertEquals("abcdefghij", contact.getContactID());
        assertEquals("PriyaDesai", contact.getFirstName());
        assertEquals("AlHassan", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123456789012345678901234567890", contact.getAddress());
    }

    @Test
    public void testContactIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Yusuf", "Al-Hassan", "5551234567", "1720 Magnolia Avenue, Unit 5");
        });
    }

    @Test
    public void testContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("toolongcontactid", "Priya", "Desai", "5551234567", "3170 Lakeview Terrace, Suite 301");
        });
    }

    @Test
    public void testContactIDNotUpdatable() {
        Contact contact = new Contact("1111111111", "Jun", "Park", "2223334444", "22 North Ocean Blvd, Floor 4");
        contact.setFirstName("Fatima");
        contact.setLastName("Zahra");
        contact.setPhone("9999999999");
        contact.setAddress("95 Riverbend Road, Building A");
        assertEquals("1111111111", contact.getContactID());
    }

    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Mori", "5551234567", "4829 Willow Creek Drive, Apt 12B");
        });
    }

    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "ThisNameIsTooLong", "Mori", "5551234567", "1720 Magnolia Avenue, Unit 5");
        });
    }

    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alessia", null, "5551234567", "3170 Lakeview Terrace, Suite 301");
        });
    }

    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alessia", "ThisLastNameIsTooLong", "5551234567", "22 North Ocean Boulevard, Floor 4");
        });
    }

    @Test
    public void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alessia", "Mori", null, "95 Riverbend Road, Building A");
        });
    }

    @Test
    public void testPhoneWrongLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alessia", "Mori", "12345", "6100 Sunset Ridge Court, Apt 207");
        });
    }

    @Test
    public void testPhoneNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alessia", "Mori", "555abc7890", "1501 Grandview Parkway, Unit 17");
        });
    }

    @Test
    public void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alessia", "Mori", "5551234567", null);
        });
    }

    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Alessia", "Mori", "5551234567", "This address is definitely more than thirty characters long!");
        });
    }
}
