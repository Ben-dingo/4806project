package test;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersistenceTest {

	@org.junit.Test
	public void persistenceTest1() {
		ArrayList<BuddyInfo> input =  new ArrayList<BuddyInfo>();
		input.add(new BuddyInfo("Audrey B. Taylor", "517-347-3777"));
		input.add(new BuddyInfo("John E. Kirkham", "269-407-1563"));
		input.add(new BuddyInfo("Diana D. Rodriguez", "269-407-1563"));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		for (BuddyInfo b : input) {
			em.persist(b);
		}
		tx.commit();

		Query q = em.createQuery("SELECT b FROM bookFeatures);

		List<BuddyInfo> output =  q.getResultList();

		for (BuddyInfo b : input) {
			assertTrue(output.contains(b));
		}

		tx.begin();
		for (BuddyInfo b : input) {
			em.remove(b);
		}
		tx.commit();

		em.close();
		emf.close();
	}

	@org.junit.Test
	public void persistenceTest2() {
		AddressBook input =  new AddressBook(77);
		input.addEntry(new BuddyInfo("Audrey B. Taylor", "517-347-3777"));
		input.addEntry(new BuddyInfo("John E. Kirkham", "269-407-1563"));
		input.addEntry(new BuddyInfo("Diana D. Rodriguez", "269-407-1563"));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		for (BuddyInfo b : input.entries) {
			em.persist(b);
		}
		tx.commit();
		tx.begin();
		em.persist(input);
		tx.commit();

		Query q = em.createQuery("SELECT x FROM bookFeaturesx");

		List<AddressBook> output =  q.getResultList();

		assertTrue(output.size() == 1);
		AddressBook particular = output.get(0);
		assertTrue(particular.getId() == input.getId() );

		for (BuddyInfo b : input.entries) {
			assertTrue(particular.entries.contains(b));
		}

		em.close();
		emf.close();
	}

	@org.junit.Test
	public void persistenceTest3() {
		AddressBook input =  new AddressBook();
		input.addEntry(new BuddyInfo("Audrey B. Taylor", "517-347-3777"));
		input.addEntry(new BuddyInfo("John E. Kirkham", "269-407-1563"));
		input.addEntry(new BuddyInfo("Diana D. Rodriguez", "269-407-1563"));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(input);
		tx.commit();

		Query q = em.createQuery("SELECT x FROM bookFeaturesx");

		List<AddressBook> output =  q.getResultList();

		assertTrue(output.size() == 1);
		AddressBook particular = output.get(0);
		assertTrue(particular.getId() == input.getId() );

		for (BuddyInfo b : input.entries) {
			assertTrue(particular.entries.contains(b));
		}

		em.close();
		emf.close();
	}
}