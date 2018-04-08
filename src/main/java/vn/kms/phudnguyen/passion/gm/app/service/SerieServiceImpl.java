package vn.kms.phudnguyen.passion.gm.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.kms.phudnguyen.passion.gm.app.dto.SerieDTO;
import vn.kms.phudnguyen.passion.gm.app.entity.Episode;
import vn.kms.phudnguyen.passion.gm.app.entity.Serie;
import vn.kms.phudnguyen.passion.gm.app.mapper.DomainMapper;
import vn.kms.phudnguyen.passion.gm.app.repository.EpisodeRepository;
import vn.kms.phudnguyen.passion.gm.app.repository.SerieRepository;

import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements SerieService {
  @Autowired
  private SerieRepository serieRepository;

  @Autowired
  private EpisodeRepository episodeRepository;

  @Override
  public SerieDTO findById(String id) {
    Serie serie = serieRepository.findById(id).get();
    SerieDTO serieDTO = DomainMapper.toSerieDTO(serie);
    serieDTO.setEpisodes(episodeRepository.findAllBySerieId(serie.getId()).stream()
        .map(DomainMapper::toEpisodeDTO)
        .collect(Collectors.toList()));
    return serieDTO;
  }
}
