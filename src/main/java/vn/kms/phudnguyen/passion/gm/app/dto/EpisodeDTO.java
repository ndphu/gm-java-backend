package vn.kms.phudnguyen.passion.gm.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EpisodeDTO {
  String title;
  String subTitle;
  int order;
  String videoSource;
}
