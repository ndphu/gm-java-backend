package vn.kms.phudnguyen.passion.gm.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.kms.phudnguyen.passion.gm.app.entity.Category;

import java.util.List;

public interface CategoryRepository extends PagingAndSortingRepository<Category, String>{
  List<Category> findAll();

}
