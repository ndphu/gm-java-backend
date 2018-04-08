package vn.kms.phudnguyen.passion.gm.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LiteSerieDTO {
  String id;
  String title;
  String poster;
  CategoryDTO category;
  Long views;
  Long likes;
}
