package vn.kms.phudnguyen.passion.gm.app.service;

import org.springframework.data.domain.Page;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteMovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.MovieDTO;

public interface MovieService {
  Page<LiteMovieDTO> findPaginated(int page, int size);

  MovieDTO findById(String id);
}
