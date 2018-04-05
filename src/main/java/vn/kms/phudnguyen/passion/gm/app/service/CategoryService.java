package vn.kms.phudnguyen.passion.gm.app.service;

import org.springframework.data.domain.Page;
import vn.kms.phudnguyen.passion.gm.app.dto.CategoryDTO;

public interface CategoryService {
  CategoryDTO findById(String id);

  Page<CategoryDTO> findPaginated(int page, int size);
}
