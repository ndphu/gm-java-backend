package vn.kms.phudnguyen.passion.gm.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.kms.phudnguyen.passion.gm.app.dto.EpisodeDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Episode;

import java.util.List;

public interface EpisodeRepository extends PagingAndSortingRepository<Episode, String> {
  List<Episode> findAllBySerieId(String id);
}
