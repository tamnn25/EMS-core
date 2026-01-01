package system.JavaCoreDocs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collection {
//    int     → Integer
//    boolean → Boolean
//    char    → Character
//    double  → Double
    public static void listSetMap(){

        // =======================
        // LIST
        // =======================
        // ✔ Ordered (maintains insertion order)
        // ✔ Allows duplicate elements
        // ✔ Access elements by index
        // ✔ Good for iteration and random access
        // ❌ Does NOT enforce uniqueness
        List<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Apple");   // allowed
        list.add("Banana");

        System.out.println(list.get(0)); // index access → "Apple"

        // =======================
        // SET
        // =======================
        // ✔ No duplicate elements
        // ❌ No index-based access
        // ❌ Order NOT guaranteed (HashSet)
        // ✔ Fast lookup (contains)
        // ✔ Good for uniqueness checks
        Set<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Apple");   // ignored
        set.add("Banana");
        // set.get(0); ❌ Compile-time error

        System.out.println(set.contains("Apple")); // true

        // =======================
        // KEY DIFFERENCES (SUMMARY)
        // =======================
        //
        // List:
        // - Ordered
        // - Allows duplicates
        // - Index-based access
        // - Example use cases:
        //   • Shopping cart
        //   • Ordered data
        //   • Duplicates allowed
        //
        // Set:
        // - No duplicates
        // - No index access
        // - Order depends on implementation
        // - Example use cases:
        //   • Unique users
        //   • Removing duplicates
        //   • Membership checks


    }
}
