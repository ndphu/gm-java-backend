package vn.kms.phudnguyen.passion.gm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteMovieDTO;
import vn.kms.phudnguyen.passion.gm.app.service.SearchService;

@RestController
@RequestMapping("/api/search")
public class SearchController {

  @Autowired
  private SearchService searchService;

  @GetMapping
  @RequestMapping(value = "/byCategoryKey", params = {"key", "page", "size"})
  Page<LiteMovieDTO> searchByCategoryKey(
      @RequestParam("key") String key,
      @RequestParam("page") int page, @RequestParam("size") int size) {
    return searchService.searchByCategoryKey(key, page, size);
  }

  @GetMapping
  @RequestMapping(value = "/byActorKey", params = {"key", "page", "size"})
  Page<LiteMovieDTO> searchByActorKey(
      @RequestParam("key") String key,
      @RequestParam("page") int page, @RequestParam("size") int size) {
    return searchService.searchByActorKey(key, page, size);
  }

  @GetMapping
  @RequestMapping(value = "/byTitle", params = {"query", "page", "size"})
  Page<LiteMovieDTO> searchByTitle(
      @RequestParam("query") String query,
      @RequestParam("page") int page, @RequestParam("size") int size) {
    return searchService.searchByTitle(query, page, size);
  }


}
