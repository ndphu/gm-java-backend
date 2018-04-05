package vn.kms.phudnguyen.passion.gm.app.mapper;

import vn.kms.phudnguyen.passion.gm.app.dto.ActorDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.CategoryDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteMovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.MovieDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Actor;
import vn.kms.phudnguyen.passion.gm.app.entity.Category;
import vn.kms.phudnguyen.passion.gm.app.entity.Movie;

import java.util.stream.Collectors;

public class DomainMapper {
  public static MovieDTO toMovieDTO(Movie m) {
    return MovieDTO.builder()
        .id(m.getId())
        .title(m.getTitle())
        .poster(m.getPoster())
        .bigPoster(m.getBigPoster())
        .content(m.getContent())
        .actors(m.getActors().stream()
            .map(DomainMapper::toActorDTO)
            .collect(Collectors.toList()))
        .categories(m.getCategories().stream()
            .map(DomainMapper::toCategoryDTO)
            .collect(Collectors.toList()))
        .releaseDate(m.getReleaseDate())
        .videoSource(m.getVideoSource())
        .build();
  }

  public static ActorDTO toActorDTO(Actor a) {
    return ActorDTO.builder()
        .id(a.getId())
        .key(a.getKey())
        .title(a.getTitle())
        .build();
  }

  public static CategoryDTO toCategoryDTO(Category c) {
    return CategoryDTO.builder()
        .id(c.getId())
        .key(c.getKey().replaceAll(" ", "-").toLowerCase())
        .title(c.getTitle())
        .build();
  }

  public static LiteMovieDTO toLiteMovieDTO(Movie m) {
    return LiteMovieDTO.builder()
        .id(m.getId())
        .poster(m.getPoster())
        .title(m.getTitle())
        .build();
  }
}
