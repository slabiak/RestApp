import com.slabiak.utility.PrimesHelper;
import org.junit.Assert;
import org.junit.Test;

public class PrimeControllerTest {

    @Test
    public void shouldBePrime(){
        boolean result = PrimesHelper.isPrime(997);
        Assert.assertTrue(result);
    }

    @Test
    public void shouldNotBePrime(){
        boolean result = PrimesHelper.isPrime(1000);
        Assert.assertFalse(result);
    }


}
