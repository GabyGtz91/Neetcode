package arrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
        List<List<String>> resultado = groupAnagrams(strs);
        resultado.forEach(strings -> strings.forEach(s -> System.out.println(s)));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length < 1 || strs.length > 1000) {
            return null;
        } else {
            HashMap<String, List<String>> hashResultados = new HashMap<>();

            for (int i = 0; i < strs.length; i++) {
                int[] valores = new int[26];
                char[] caracteres = strs[i].toCharArray();

                for (int j = 0; j < caracteres.length; j++) {
                    valores[caracteres[j] - 'a']++;
                }

                List<String> nuevo = new ArrayList<>();
                if (hashResultados.containsKey(Arrays.toString(valores))) {
                    nuevo = hashResultados.get(Arrays.toString(valores));
                }
                nuevo.add(strs[i]);

                hashResultados.put(Arrays.toString(valores), nuevo);
            }

            List<List<String>> resultado = new ArrayList<>(hashResultados.values());
            return resultado;
        }
    }
}
