package learningFeatures;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "program", path = "program")
public interface ProgramRepository extends PagingAndSortingRepository<Program, Long>  {
}
