package vn.kms.phudnguyen.passion.gm.app.mapper;

import org.apache.commons.lang3.StringUtils;
import vn.kms.phudnguyen.passion.gm.app.dto.ActorDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.CategoryDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.EpisodeDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteMovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.LiteSerieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.MovieDTO;
import vn.kms.phudnguyen.passion.gm.app.dto.SerieDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Actor;
import vn.kms.phudnguyen.passion.gm.app.entity.Category;
import vn.kms.phudnguyen.passion.gm.app.entity.Episode;
import vn.kms.phudnguyen.passion.gm.app.entity.Movie;
import vn.kms.phudnguyen.passion.gm.app.entity.Serie;

import java.text.Normalizer;
import java.util.Random;
import java.util.stream.Collectors;

public class DomainMapper {

  static Random RANDOM = new Random(System.currentTimeMillis());

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
        .category(DomainMapper.toCategoryDTO(m.getCategories().get(0)))
        .views((long) (RANDOM.nextInt(2000) + 1))
        .likes((long) (RANDOM.nextInt(2000) + 1))
        .build();
  }

  public static LiteMovieDTO toLiteMovieDTO(Movie m, String categoryKey) {
    return LiteMovieDTO.builder()
        .id(m.getId())
        .poster(m.getPoster())
        .title(m.getTitle())
        .category(DomainMapper.toCategoryDTO(m.getCategories().stream()
            .filter(category -> category.getKey().equals(categoryKey))
            .findFirst().get()))
        .views((long) (RANDOM.nextInt(2000) + 1))
        .likes((long) (RANDOM.nextInt(2000) + 1))
        .build();
  }

  public static LiteSerieDTO toLiteSerieDTO(Serie serie) {

    return LiteSerieDTO.builder()
        .id(serie.getId())
        .poster(serie.getPoster())
        .title(serie.getTitle())
        .category(CategoryDTO.builder()
            .key(StringUtils.stripAccents(serie.getCategories().get(0).toLowerCase()
                .replaceAll(" ", "-")))
            .title(serie.getCategories().get(0))
            .build())
        .views((long) (RANDOM.nextInt(2000) + 1))
        .likes((long) (RANDOM.nextInt(2000) + 1))
        .build();
  }

  public static SerieDTO toSerieDTO(Serie serie) {
    return SerieDTO.builder()
        .id(serie.getId())
        .title(serie.getTitle())
        .poster(serie.getPoster())
        .bigPoster(serie.getBigPoster())
        .content(serie.getContent())
        .actors(serie.getActors().stream()
            .map(DomainMapper::toActorDTOFromTitle)
            .collect(Collectors.toList()))
        .categories(serie.getCategories().stream()
            .map(DomainMapper::toCategoryDTOFromTitle)
            .collect(Collectors.toList()))
        .build();
  }

  public static ActorDTO toActorDTOFromTitle(String actorTitle) {
    return ActorDTO.builder()
        .key(convertTitleToKey(actorTitle))
        .title(actorTitle).build();
  }

  public static CategoryDTO toCategoryDTOFromTitle(String categoryTitle) {
    return CategoryDTO.builder()
        .key(convertTitleToKey(categoryTitle))
        .title(categoryTitle).build();
  }

  private static String convertTitleToKey(String categoryTitle) {
    return StringUtils.stripAccents(categoryTitle)
        .replaceAll(" ", "-")
        .toLowerCase();
  }

  public static EpisodeDTO toEpisodeDTO(Episode episode) {
    return EpisodeDTO.builder()
        .title(episode.getTitle())
        .subTitle(episode.getSubTitle())
        .videoSource(episode.getVideoSource())
        .order(episode.getOrder())
        .build();
  }
}
