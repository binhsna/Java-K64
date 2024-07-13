package Locale;

import java.util.Locale;

public class AllLocale {
    public static void main(String[] args) {
        Locale[] arr = Locale.getAvailableLocales();
        for (Locale str : arr) {
            System.out.println("Quốc gia: " + str.getDisplayCountry() +
                    ", Mã quốc gia: " + str.getCountry() +
                    ", Ngôn ngữ: " + str.getDisplayLanguage() +
                    ", Mã ngôn ngữ: " + str.getLanguage());
        }
    }
}