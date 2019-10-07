package shasha.company.CompetitionHackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Result {

    /*
     * Complete the 'productName' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY names as parameter.
     */

    public static String productName(List<String> names) {
        ArrayList<TreeSet<Character>> s = new ArrayList<>(5);
        for (int j = 0; j < names.size(); j++) {
            s.add(new TreeSet<>());
            for (int i = 0; i < names.get(j).length(); i++) {
                s.get(j).add(names.get(j).charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (char j = 'z'; j >= 'a'; j--) {
                if (!s.get(i).contains(j)) {
                    result.append(j);
                    break;
                }
            }
        }
        return result.toString();
    }

}
