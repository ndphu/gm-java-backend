package vn.kms.phudnguyen.passion.gm.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LiteMovieDTO {
  String id;
  String title;
  String poster;
}
