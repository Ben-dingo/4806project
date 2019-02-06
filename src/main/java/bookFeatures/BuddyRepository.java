package bookFeatures;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddy", path = "buddy")
public interface BuddyRepository extends CrudRepository<BuddyInfo, Long> {
	List<BuddyInfo> findByName(String name);
}
