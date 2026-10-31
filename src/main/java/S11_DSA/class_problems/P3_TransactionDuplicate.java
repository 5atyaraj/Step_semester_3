import java.util.*;

public class P3_TransactionDuplicate {

    static boolean hasDuplicate(String[] ids) {
        HashSet<String> set = new HashSet<>();

        for (String id : ids) {
            if (!set.add(id))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        String[] a = {
            "TXN1001", "TXN1002", "TXN1003",
            "TXN1002", "TXN1004"
        };

        String[] b = {
            "TXN2001", "TXN2002", "TXN2003"
        };

        System.out.println(hasDuplicate(a));
        System.out.println(hasDuplicate(b));
    }
}
