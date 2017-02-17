import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.TreeMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    private HashMap<String, Integer> hashMap = new HashMap<>();

    @BeforeEach
    void init() {
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
    }

    @Test
    void hashMap() throws Exception {
        assertTrue(hashMap.containsKey("Smith")); // {=, Lewis=29, Anderson=31, Cook=29}
        assertThat(hashMap.get("Smith"), is(30)); // {=, Lewis=29, Anderson=31, Cook=29}
    }

    @Test
    void treeMap() throws Exception {
        val treeMap = new TreeMap<String, Integer>(hashMap);
        assertTrue(treeMap.firstKey().equals("Anderson"));
        assertTrue(treeMap.lastKey().equals("Smith"));
    }
}