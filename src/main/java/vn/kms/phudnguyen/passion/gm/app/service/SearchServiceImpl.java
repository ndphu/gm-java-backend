package vn.kms.phudnguyen.passion.gm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteMovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteSerieDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Movie;
import vn.kms.phudnguyen.passion.gm.app.entity.Serie;
import vn.kms.phudnguyen.passion.gm.app.mapper.DomainMapper;
import vn.kms.phudnguyen.passion.gm.app.repository.MovieRepository;
import vn.kms.phudnguyen.passion.gm.app.repository.SerieRepository;

import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {
  @Autowired
  private MovieRepository movieRepository;
  @Autowired
  private SerieRepository serieRepository;

  @Override
  public Page<LiteMovieDTO> searchByCategoryKey(String categoryKey, int page, int size) {
    PageRequest pageable = PageRequest.of(page, size);
    Page<Movie> movies = movieRepository.findByCategoriesKey(categoryKey, pageable);
    return new PageImpl<>(
        movies.getContent().stream()
            .map(m -> DomainMapper.toLiteMovieDTO(m, categoryKey))
            .collect(Collectors.toList()),
        pageable,
        movies.getTotalElements()
    );
  }

  @Override
  public Page<LiteMovieDTO> searchByActorKey(String actorKey, int page, int size) {
    PageRequest pageable = PageRequest.of(page, size);
    Page<Movie> movies = movieRepository.findByActorsKey(actorKey, pageable);
    return new PageImpl<>(
        movies.getContent().stream()
            .map(DomainMapper::toLiteMovieDTO)
            .collect(Collectors.toList()),
        pageable,
        movies.getTotalElements()
    );
  }

  @Override
  public Page<LiteMovieDTO> searchByTitle(String query, int page, int size) {
    PageRequest pageable = PageRequest.of(page, size);
    Page<Movie> movies = movieRepository.findByTitleContainsIgnoreCase(query, pageable);
    return new PageImpl<>(
        movies.getContent().stream()
            .map(DomainMapper::toLiteMovieDTO)
            .collect(Collectors.toList()),
        pageable,
        movies.getTotalElements()
    );
  }

  @Override
  public Page<LiteSerieDTO> searchSerieByTitle(String query, int page, int size) {
    PageRequest pageable = PageRequest.of(page, size);
    Page<Serie> series = serieRepository.findAllByTitleContainsIgnoreCase(query, pageable);
    return new PageImpl<>(
        series.getContent().stream()
            .map(DomainMapper::toLiteSerieDTO)
            .collect(Collectors.toList()),
        pageable,
        series.getTotalElements()
    );
  }
}
