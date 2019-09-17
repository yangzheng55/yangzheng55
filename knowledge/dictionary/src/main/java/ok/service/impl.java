package ok.service;

import ok.dao.HotnewsMapper;
import ok.domain.Hotnews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class impl implements HotnewsService {
    @Autowired
    private HotnewsMapper hotnewsMapper;

    @Override
    public void insert(Hotnews hotnews) {
        hotnewsMapper.insert(hotnews);
    }

    @Override
    public Hotnews select(Integer id) {
        Hotnews h = new Hotnews();
        h.setName("zy");
        return hotnewsMapper.selectOne(h);
    }
}
