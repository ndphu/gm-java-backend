package vn.kms.phudnguyen.passion.gm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.kms.phudnguyen.passion.gm.app.dto.ActorDTO;
import vn.kms.phudnguyen.passion.gm.app.service.ActorService;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
  @Autowired
  private ActorService actorService;

  @GetMapping
  @RequestMapping(value = "/{id}")
  public ActorDTO findById(@PathVariable String id) {
    return actorService.findById(id);
  }

  @GetMapping
  @RequestMapping(params = { "page", "size" })
  @Cacheable("actors")
  public Page<ActorDTO> findAllPaginated(
      @RequestParam( "page" ) int page, @RequestParam( "size" ) int size
  ) {
    return actorService.findPaginated(page, size);
  }
}
