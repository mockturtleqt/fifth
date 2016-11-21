import com.epam.fifth.action.parsing.TourStaxBuilder;
import org.junit.Test;

public class TourStaxTest {
    @Test
    public void staxTest() {
        TourStaxBuilder staxBuilder = new TourStaxBuilder();
        staxBuilder.buildSetTours("./data/voucher.xml");
        System.out.println(staxBuilder.getTours());
    }
}
