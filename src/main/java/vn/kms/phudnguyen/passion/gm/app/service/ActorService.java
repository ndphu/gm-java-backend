package vn.kms.phudnguyen.passion.gm.app.service;

import org.springframework.data.domain.Page;
import vn.kms.phudnguyen.passion.gm.app.dto.ActorDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.CategoryDTO;

import java.util.List;

public interface ActorService {
  ActorDTO findById(String id);

  Page<ActorDTO> findPaginated(int page, int size);
}
