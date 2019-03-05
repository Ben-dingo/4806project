package learningFeatures;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
