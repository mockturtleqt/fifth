import com.epam.fifth.action.Validation;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ValidationTest {
    @Test
    public void validationTest() {
        assertTrue(Validation.validateXMLSchema("./data/voucher.xsd", "./data/voucher.xml"));
    }
}
