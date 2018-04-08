package vn.kms.phudnguyen.passion.gm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteMovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteSerieDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Serie;
import vn.kms.phudnguyen.passion.gm.app.repository.SerieRepository;
import vn.kms.phudnguyen.passion.gm.app.service.SearchService;

@RestController
@RequestMapping("/api/search/serie")
public class SerieSearchController {

  @Autowired
  private SearchService searchService;

  @GetMapping
  @RequestMapping(value = "/byTitle", params = {"query", "page", "size"})
  Page<LiteSerieDTO> searchByTitle(
      @RequestParam("query") String query,
      @RequestParam("page") int page, @RequestParam("size") int size) {
    return searchService.searchSerieByTitle(query, page, size);
  }


}
