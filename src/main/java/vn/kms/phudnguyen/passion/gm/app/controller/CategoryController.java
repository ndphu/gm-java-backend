package vn.kms.phudnguyen.passion.gm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vn.kms.phudnguyen.passion.gm.app.dto.CategoryDTO;
import vn.kms.phudnguyen.passion.gm.app.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @GetMapping
  @RequestMapping(value = "/{id}")
  CategoryDTO findById(@PathVariable String id) {
    return categoryService.findById(id);
  }

  @GetMapping
  @RequestMapping(params = {"page", "size"})
  Page<CategoryDTO> findAllPaginated(
      @RequestParam("page") int page, @RequestParam("size") int size) {
    return categoryService.findPaginated(page, size);
  }
}
