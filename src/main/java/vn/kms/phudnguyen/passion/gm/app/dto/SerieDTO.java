package vn.kms.phudnguyen.passion.gm.app.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SerieDTO {
  String id;
  String title;
  String poster;
  String bigPoster;
  String content;
  String releaseDate;
  List<ActorDTO> actors;
  List<CategoryDTO> categories;
  List<EpisodeDTO> episodes;
}