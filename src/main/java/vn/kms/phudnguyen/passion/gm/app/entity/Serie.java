package vn.kms.phudnguyen.passion.gm.app.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "series")
@Builder
@Data
public class Serie {
  @Id
  String id;
  String title;
  String poster;
  String bigPoster;
  String content;
  List<String> directors;
  List<String> actors;
  List<String> categories;
}
