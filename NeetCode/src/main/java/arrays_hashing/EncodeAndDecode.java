package arrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class EncodeAndDecode {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("neet");
        strs.add("code");
        strs.add("love");
        strs.add("you");

        String stringEncode = encode(strs);
        List<String> listaDecodificada = decode(stringEncode);

        for (String s : listaDecodificada) {
            System.out.println(s);
        }

    }

    public static String encode(List<String> strs) {
        String stringEncode = "";
        for (String s : strs) {
            stringEncode = stringEncode + s + "¬";
        }
        stringEncode = Base64.getEncoder().encodeToString(stringEncode.getBytes());
        return stringEncode;
    }

    public static List<String> decode(String str) {
        byte[] decodedBytes = Base64.getDecoder().decode(str);

        String cadena = new String(decodedBytes);
        String[] cadenaSeparada = cadena.split("¬");

        List<String> listaDecodificada = new ArrayList<>(Arrays.asList(cadenaSeparada));

        return listaDecodificada;
    }
}
