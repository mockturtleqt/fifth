import com.epam.fifth.action.parsing.TourDomBuilder;
import org.junit.Test;

public class TourDomTest {
    @Test
    public void domTest() {
        TourDomBuilder domBuilder = new TourDomBuilder();
        domBuilder.buildSetTours("./data/voucher.xml");
        System.out.println(domBuilder.getTours());
    }
}
