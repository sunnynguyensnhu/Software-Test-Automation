package contactapp;

import java.util.HashMap;
import java.util.Map;

// Simple service to add, update, and remove contacts (all in memory, no DB)
// Using HashMap so we can find contacts by ID quickly
public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact - must have a unique ID
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact can't be null");
        }
        // Check for duplicate IDs before adding
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Duplicate ID: " + contact.getContactID());
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Remove contact by ID (must exist)
    public void deleteContact(String contactID) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID can't be null");
        }
        if (!contacts.containsKey(contactID)) {
            // Nothing to delete if the ID isn't found
            throw new IllegalArgumentException("Contact ID not found: " + contactID);
        }
        contacts.remove(contactID);
    }

    // Update first name of a contact (ID must exist)
    public void updateFirstName(String contactID, String firstName) {
        Contact contact = getContact(contactID); // Throws if not found
        contact.setFirstName(firstName); // Let Contact class do the validation
    }

    // Update last name
    public void updateLastName(String contactID, String lastName) {
        Contact contact = getContact(contactID);
        contact.setLastName(lastName);
    }

    // Update phone number
    public void updatePhone(String contactID, String phone) {
        Contact contact = getContact(contactID);
        contact.setPhone(phone);
    }

    // Update address
    public void updateAddress(String contactID, String address) {
        Contact contact = getContact(contactID);
        contact.setAddress(address);
    }

    // Helper to fetch contact (throws if not found)
    public Contact getContact(String contactID) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID can't be null");
        }
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found: " + contactID);
        }
        return contact;
    }

    // For testing: see if we have a contact by ID
    public boolean containsContact(String contactID) {
        return contacts.containsKey(contactID);
    }

    // For testing: how many contacts in service
    public int getContactCount() {
        return contacts.size();
    }
}
