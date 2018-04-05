package vn.kms.phudnguyen.passion.gm.app.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "actors")
public class Actor {
  String id;
  String title;
  String key;
}
