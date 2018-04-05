package vn.kms.phudnguyen.passion.gm.app.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
public class CategoryDTO {
  String id;
  String title;
  String key;
}

