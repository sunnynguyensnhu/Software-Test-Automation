package contactapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

// Tests for the ContactService class
public class ContactServiceTest {

    private ContactService contactService;
    private Contact testContact;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        testContact = new Contact("ALEX123", "Alessia", "Mori", "5551234567", "4829 Adrian Dr, Apt 12B");
    }

    @Test
    public void testAddContactSuccess() {
        contactService.addContact(testContact);
        assertEquals(1, contactService.getContactCount());
        assertTrue(contactService.containsContact("ALEX123"));
        assertEquals(testContact, contactService.getContact("ALEX123"));
    }

    @Test
    public void testAddMultipleContacts() {
        Contact contact1 = new Contact("YUSUF88", "Yusuf", "Al-Hassan", "5551111111", "1720 Huran Dr, Unit 5");
        Contact contact2 = new Contact("PRIYA22", "Priya", "Desai", "5552222222", "3170 Sunrock Ln, Suite 301");
        Contact contact3 = new Contact("JUN777", "Jun", "Park", "5553333333", "22 Story Rd, Floor 4");
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        contactService.addContact(contact3);
        assertEquals(3, contactService.getContactCount());
        assertTrue(contactService.containsContact("YUSUF88"));
        assertTrue(contactService.containsContact("PRIYA22"));
        assertTrue(contactService.containsContact("JUN777"));
    }

    @Test
    public void testAddContactWithDuplicateID() {
        contactService.addContact(testContact);
        Contact dup = new Contact("ALEX123", "Fatima", "Zahra", "1234567890", "95 Riverbend Road, Building A");
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(dup);
        });
        assertEquals(1, contactService.getContactCount());
    }

    @Test
    public void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
        assertEquals(0, contactService.getContactCount());
    }

    @Test
    public void testDeleteContactSuccess() {
        contactService.addContact(testContact);
        contactService.deleteContact("ALEX123");
        assertEquals(0, contactService.getContactCount());
        assertFalse(contactService.containsContact("ALEX123"));
    }

    @Test
    public void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("MISSING");
        });
    }

    @Test
    public void testUpdateFirstName() {
        contactService.addContact(testContact);
        contactService.updateFirstName("ALEX123", "Matteo");
        assertEquals("Matteo", contactService.getContact("ALEX123").getFirstName());
    }

    @Test
    public void testUpdateFirstNameNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("MISSING", "NewName");
        });
    }

    @Test
    public void testUpdateLastName() {
        contactService.addContact(testContact);
        contactService.updateLastName("ALEX123", "Rossi");
        assertEquals("Rossi", contactService.getContact("ALEX123").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        contactService.addContact(testContact);
        contactService.updatePhone("ALEX123", "9876543210");
        assertEquals("9876543210", contactService.getContact("ALEX123").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        contactService.addContact(testContact);
        contactService.updateAddress("ALEX123", "9546 Captol Wy, Apt 207");
        assertEquals("9546 Captol Wy, Apt 207", contactService.getContact("ALEX123").getAddress());
    }

    @Test
    public void testUpdateLastNameNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("MISSING", "Smith");
        });
    }

    @Test
    public void testUpdatePhoneNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("MISSING", "0123456789");
        });
    }

    @Test
    public void testUpdateAddressNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("MISSING", "1501 Grandview Parkway, Unit 17");
        });
    }
}
