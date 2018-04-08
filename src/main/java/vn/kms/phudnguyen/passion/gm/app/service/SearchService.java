package vn.kms.phudnguyen.passion.gm.app.service;

import org.springframework.data.domain.Page;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteMovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteSerieDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Serie;

public interface SearchService {
  Page<LiteMovieDTO> searchByCategoryKey(String categoryKey, int page, int size);

  Page<LiteMovieDTO> searchByActorKey(String actorKey, int page, int size);

  Page<LiteMovieDTO> searchByTitle(String query, int page, int size);

  Page<LiteSerieDTO> searchSerieByTitle(String query, int page, int size);
}
