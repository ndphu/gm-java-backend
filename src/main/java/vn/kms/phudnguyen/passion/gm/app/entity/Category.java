package vn.kms.phudnguyen.passion.gm.app.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "categories")
public class Category {
  String id;
  String title;
  String key;
}

