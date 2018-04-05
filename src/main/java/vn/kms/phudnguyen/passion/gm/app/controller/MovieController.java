package vn.kms.phudnguyen.passion.gm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteMovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.MovieDTO;
import vn.kms.phudnguyen.passion.gm.app.service.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
  @Autowired
  private MovieService movieService;

  @GetMapping
  @RequestMapping(value = "/{id}")
  MovieDTO findById(@PathVariable String id) {
    return movieService.findById(id);
  }

  @GetMapping
  @RequestMapping(params = { "page", "size" })
  Page<LiteMovieDTO> findAllPaginated(
      @RequestParam( "page" ) int page, @RequestParam( "size" ) int size
  ) {
    return movieService.findPaginated(page, size);
  }
}
