package learningFeatures;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "objective", path = "objective")
public interface LearningObjectiveRepository extends CrudRepository<LearningObjective, Long> {
	List<LearningObjective> findByName(String name);
}
