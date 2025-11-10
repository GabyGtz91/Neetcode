package arrays_hashing;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6};
        int target = 7;
        int[] solucion = twoSum(nums, target);
        System.out.println("Resultado: [" + solucion[0] + ", " + solucion[1] + "]");
    }

    public static int[] twoSum(int[] nums, int target) {
        if(nums.length < 2 || nums.length > 1000) {
            return null;
        } else {
            HashMap<Integer, Integer> hashNums = new HashMap<>();
            int valorBuscar;
            int[] resultado = new int[2];

            for (int i = 0; i < nums.length; i++) {
                valorBuscar = target - nums[i];
                if (hashNums.containsKey(valorBuscar)) {
                    resultado[0] = hashNums.get(valorBuscar);
                    resultado[1] = i;
                    return resultado;
                } else {
                    hashNums.put(nums[i], i);
                }
            }
            return null;
        }
    }
}
