package vn.kms.phudnguyen.passion.gm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteMovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.MovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.SerieDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Serie;
import vn.kms.phudnguyen.passion.gm.app.repository.SerieRepository;
import vn.kms.phudnguyen.passion.gm.app.service.MovieService;
import vn.kms.phudnguyen.passion.gm.app.service.SerieService;

@RestController
@RequestMapping("/api/serie")
public class SerieController {
  @Autowired
  private SerieService serieService;

  @GetMapping
  @RequestMapping(value = "/{id}")
  public SerieDTO findById(@PathVariable String id) {
    return serieService.findById(id);
  }

}
