package arrays_hashing;

import java.sql.Connection;
import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3};
        int k = 2;
        int[] resultado = topKFrequent(nums, k);

        String valores = "";
        for (int i = 0; i < resultado.length; i++) {
            valores += resultado[i] + ", ";
        }
        System.out.println("[" + valores.substring(0, valores.length()-2) + "]");
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if(nums.length < 1 || nums.length > 10000 ||
            k < 1 || k > Arrays.stream(nums).distinct().count()) {
            return null;
        } else {
            HashMap<Integer, Integer> hashNums = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if(nums[i] < -1000 || nums[i] > 1000) {
                    return null;
                } else {
                    hashNums.put(nums[i], hashNums.getOrDefault(nums[i], 0) + 1);
                }
            }

            List<Map.Entry<Integer, Integer>> lista = new ArrayList<>(hashNums.entrySet());
            lista.sort(Map.Entry.comparingByValue());
            Collections.reverse(lista);

            int cantidad = 0;
            int[] resultado = new int[k];
            for(Map.Entry<Integer, Integer> entry : lista) {
                resultado[cantidad] = entry.getKey();
                cantidad++;
                if (cantidad == k) {
                    break;
                }
            }

            return resultado;
        }
    }
}
