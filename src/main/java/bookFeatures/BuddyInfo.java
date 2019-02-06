package bookFeatures;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String phone;
    private String address;

    @ManyToMany(mappedBy="entries")
    private List<AddressBook> books;

    public BuddyInfo() {
        this("new", "new", "new");
    }

    public BuddyInfo(String name, String phone, String address) {
        this.name =  name;
        this.phone = phone;
        this.address = address;
        books = new ArrayList<AddressBook>();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() { return address; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) { this.address = address; }

    public List<AddressBook> getBooks() {
        return books;
    }

    public void setBooks(List<AddressBook> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\tPhone: " + phone + "\tAddress: " + address + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BuddyInfo)) {
            return false;
        }

        BuddyInfo bud =  (BuddyInfo)o;

        return (o.hashCode() == hashCode());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
