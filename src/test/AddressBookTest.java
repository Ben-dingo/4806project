package test;

import static org.junit.Assert.*;

public class AddressBookTest {

    @org.junit.Test
    public void addEntry() {
        AddressBook book = new AddressBook();
        book.addEntry(new BuddyInfo());
        book.addEntry(new BuddyInfo("Mario","263-874-4721"));
        assertTrue(book.entries.size() == 2);
    }

    @org.junit.Test
    public void toStringTest() {
        AddressBook book = new AddressBook();
        book.addEntry(new BuddyInfo("Mario","263-874-4721"));
        assertTrue(book.toString().contains("Mario"));
        assertTrue(book.toString().contains("263-874-4721"));
    }
}