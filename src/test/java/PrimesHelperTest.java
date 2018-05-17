import com.slabiak.utility.PrimesHelper;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.core.IsCollectionContaining;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PrimesHelperTest {

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

    @Test
    public void shouldRemoveDuplicate(){
        ArrayList<Integer> duplicatesList = new ArrayList<Integer>();
        ArrayList<Integer> uniquesList = new ArrayList<Integer>();
        duplicatesList.add(1);
        duplicatesList.add(2);
        duplicatesList.add(2);
        duplicatesList.add(3);
        uniquesList = PrimesHelper.removeDuplicates(duplicatesList);
        System.out.println(uniquesList.size());
        Assert.assertThat(uniquesList, IsCollectionContaining.hasItems(1,2,3));
        Assert.assertTrue(uniquesList.size() ==3);
    }

    @Test
    public void shouldFilterPrimes(){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> primes = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(20);
        numbers.add(13);
        numbers.add(997);
        primes = PrimesHelper.filterPrimes(numbers);
        Assert.assertThat(primes, IsCollectionContaining.hasItems(13,997));
        Assert.assertTrue(primes.size() ==2);
    }

}
