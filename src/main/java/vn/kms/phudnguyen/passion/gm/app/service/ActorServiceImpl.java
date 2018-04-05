package vn.kms.phudnguyen.passion.gm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.kms.phudnguyen.passion.gm.app.dto.ActorDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.CategoryDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Actor;
import vn.kms.phudnguyen.passion.gm.app.entity.Movie;
import vn.kms.phudnguyen.passion.gm.app.mapper.DomainMapper;
import vn.kms.phudnguyen.passion.gm.app.repository.ActorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {
  @Autowired
  private ActorRepository actorRepository;

  @Override
  public ActorDTO findById(String id) {
    return DomainMapper.toActorDTO(actorRepository.findById(id).get());
  }

  @Override
  public Page<ActorDTO> findPaginated(int page, int size) {
    PageRequest pageable = PageRequest.of(page, size);
    Page<Actor> actors = actorRepository.findAll(pageable);
    return new PageImpl<>(
        actors.getContent().stream().map(DomainMapper::toActorDTO).collect(Collectors.toList()),
        pageable,
        actors.getTotalElements());
  }
}
