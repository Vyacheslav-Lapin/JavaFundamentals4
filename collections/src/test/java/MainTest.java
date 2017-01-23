import lombok.val;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class MainTest {

    HashMap<String, Integer> hashMap = new HashMap<>();

    @Before
    public void init() {
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
    }

    @Test
    public void hashMap() throws Exception {
        assertTrue(hashMap.containsKey("Smith")); // {=, Lewis=29, Anderson=31, Cook=29}
        assertTrue(hashMap.get("Smith") == 30); // {=, Lewis=29, Anderson=31, Cook=29}
    }

    @Test
    public void treeMap() throws Exception {
        val treeMap = new TreeMap<String, Integer>(hashMap);
        assertTrue(treeMap.firstKey().equals("Anderson"));
        assertTrue(treeMap.lastKey().equals("Smith"));
    }
}