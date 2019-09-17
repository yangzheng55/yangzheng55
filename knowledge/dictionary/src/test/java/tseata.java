import ok.domain.Hotnews;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ok.service.HotnewsService;

public class tseata  extends ApplicationTests{

    @Autowired
    private HotnewsService hotnewsService;

    @Test
    public void test1(){
        Hotnews hotnews = new Hotnews();
//        hotnews.setId(9);
//        hotnews.setName("xy");
//        hotnewsService.insert(hotnews);
        System.out.println(hotnewsService.select(4));

    }
}
