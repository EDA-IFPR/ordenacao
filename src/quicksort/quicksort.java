package quicksort;

import java.util.ArrayList;
import java.util.List;

public class quicksort {
    public static List<Integer> quicksort(List<Integer> nums) {
        if (nums.size() <= 1) return nums;
        int pivo = nums.get(0);
        List<Integer> menores = new ArrayList<>();
        List<Integer> maiores = new ArrayList<>();
        List<Integer> equals = new ArrayList<>();
        for (int num : nums) {
            if (num > pivo) maiores.add(num);
            else if (num < pivo) menores.add(num);
            else equals.add(num);
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(quicksort(menores));
        result.addAll(equals);
        result.addAll(quicksort(maiores));
        return result;
    }
}
