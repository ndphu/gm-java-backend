package vn.kms.phudnguyen.passion.gm.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.kms.phudnguyen.passion.gm.app.entity.Movie;

public interface MovieRepository extends PagingAndSortingRepository<Movie, String> {

  default Page<Movie> findByCategoriesKey(String categoryKey, Pageable pageable) {
    return findByCategoriesKeyAndVideoSourceNot(categoryKey, "", pageable);
  }

  Page<Movie> findByCategoriesKeyAndVideoSourceNot(String categoryEmbeddedKey, String empty, Pageable pageable);

  default Page<Movie> findByActorsKey(String actorKey, Pageable pageable) {
    return findByActorsKeyAndVideoSourceNot(actorKey, "", pageable);
  }

  Page<Movie> findByActorsKeyAndVideoSourceNot(String actorKey, String empty, Pageable pageable);

  default Page<Movie> findByTitleContainsIgnoreCase(String actor, Pageable pageable) {
    return findByTitleContainsIgnoreCaseAndVideoSourceNot(actor, "",pageable);
  }

  Page<Movie> findByTitleContainsIgnoreCaseAndVideoSourceNot(String query, String empty, Pageable pageable);
}
