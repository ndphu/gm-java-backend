package vn.kms.phudnguyen.passion.gm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteMovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.MovieDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Movie;
import vn.kms.phudnguyen.passion.gm.app.mapper.DomainMapper;
import vn.kms.phudnguyen.passion.gm.app.repository.MovieRepository;

import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
  @Autowired
  private MovieRepository movieRepository;

  @Override
  public Page<LiteMovieDTO> findPaginated(int page, int size) {
    PageRequest pageable = PageRequest.of(page, size);
    Page<Movie> movies = movieRepository.findAll(pageable);
    return new PageImpl<>(
        movies.getContent().stream().map(DomainMapper::toLiteMovieDTO).collect(Collectors.toList()),
        pageable,
        movies.getTotalElements()
    );
  }

  @Override
  public MovieDTO findById(String id) {
    Movie m = movieRepository.findById(id).get();
    return DomainMapper.toMovieDTO(m);
  }
}
