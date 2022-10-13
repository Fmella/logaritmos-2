package utils;

import java.util.Random;


public final class Utils {

    public static long time_fun(Function fun, String str1, String str2) {
        long start = System.currentTimeMillis();
        fun.call(str1, str2);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static double promedio(int cantidad, int longitud, Function fun) {
        double total = 0;
        for (int i = 0; i < cantidad; i++) {
        //    final String str1 = random_string(longitud);
        //    final String str2 = random_string(longitud);
        //    total += time_fun(fun, str1, str2);
        }
        return total / cantidad;
    }
    
}
