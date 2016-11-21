import com.epam.fifth.action.parsing.TourSaxBuilder;
import org.junit.Test;

public class TourSaxTest {
    @Test
    public void saxTest() {
        TourSaxBuilder saxBuilder = new TourSaxBuilder();
        saxBuilder.buildSetTours("./data/voucher.xml");
        System.out.println(saxBuilder.getTours());
    }
}
