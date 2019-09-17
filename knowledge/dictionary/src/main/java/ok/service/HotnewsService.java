package ok.service;

import ok.domain.Hotnews;

public interface HotnewsService {
    void insert(Hotnews hotnews);
    Hotnews select(Integer id);
}
