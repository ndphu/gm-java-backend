package vn.kms.phudnguyen.passion.gm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.kms.phudnguyen.passion.gm.app.dto.ActorDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.CategoryDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Actor;
import vn.kms.phudnguyen.passion.gm.app.entity.Category;
import vn.kms.phudnguyen.passion.gm.app.mapper.DomainMapper;
import vn.kms.phudnguyen.passion.gm.app.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public CategoryDTO findById(String id) {
    return DomainMapper.toCategoryDTO(categoryRepository.findById(id).get());
  }

  @Override
  public Page<CategoryDTO> findPaginated(int page, int size) {
    PageRequest pageable = PageRequest.of(page, size);
    Page<Category> categories = categoryRepository.findAll(pageable);
    return new PageImpl<>(
        categories.getContent().stream().map(DomainMapper::toCategoryDTO).collect(Collectors.toList()),
        pageable,
        categories.getTotalElements());
  }
}
