package vn.kms.phudnguyen.passion.gm.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.kms.phudnguyen.passion.gm.app.entity.Serie;

public interface SerieRepository extends PagingAndSortingRepository<Serie, String> {
  Page<Serie> findAllByTitleContainsIgnoreCase(String query, Pageable pageable);
}
