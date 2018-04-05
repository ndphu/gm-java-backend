package vn.kms.phudnguyen.passion.gm.app.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "movies")
@Data
public class Movie {
  String id;
  String title;
  String normTitle;
  String poster;
  String bigPoster;
  String origin;
  String source;
  String playUrl;
  String videoSource;
  String content;
  String releaseDate;
  List<String> directors;
  @Field("actorEmbeded")
  List<Actor> actors;
  @Field("categoryEmbeded")
  List<Category> categories;
}
