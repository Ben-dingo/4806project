package bookFeatures;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_buddy",
	joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "buddy_id", referencedColumnName = "id"))
	protected List<bookFeatures.BuddyInfo> entries;


	public AddressBook() {
		entries = new ArrayList<bookFeatures.BuddyInfo>();
	}

	public void removeBuddy(BuddyInfo b) {
		entries.remove(b);
	}

	public void addEntry(BuddyInfo b) {
		entries.add(b);
	}

	public List<BuddyInfo> getEntries() {
		return entries;
	}
	public void setEntries(List<BuddyInfo> entries) {
		this.entries = entries;
	}



	public long getId() {
		return id;
	}

	public static void main(String[] args) {
		Application.main(args);
	}
}
