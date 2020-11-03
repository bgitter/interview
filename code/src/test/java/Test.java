import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

/**
 * @ClassName: Test <br>
 * @Description: Test <br>
 * @Date: 2020/9/24 上午6:47 <br>
 * @Author: zxb <br>
 * @Version: 1.0 <br>
 */
public class Test {

  public static void main(String[] args) {
    int a = (int) Math.ceil(9D / 2);
    System.out.println(a);

    Multiset<String> set = HashMultiset.create();
    set.setCount("a", 3);
    set.add("a");
    set.add("a");
    System.out.println(set.count("a"));

    Multimap<String, String> multimap = HashMultimap.create();
    multimap.put("a", "1");
    multimap.put("a", "2");
    System.out.println(multimap.get("a"));
  }

}
