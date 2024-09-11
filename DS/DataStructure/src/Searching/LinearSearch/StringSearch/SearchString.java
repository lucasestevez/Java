package Searching.LinearSearch.StringSearch;

public class SearchString {
    public static void main(String[] args) {

        String el = "pneumoultramicroscopicossilicovulcanoconiótico";
        char target = 'z';

        System.out.println(linearSearch(el, target));

    }

    static boolean linearSearch(String str, char target) {

        for (char c : str.toCharArray()) {
            if (target == c) {
                return true;
            }
        }

        return false;
    }
}
