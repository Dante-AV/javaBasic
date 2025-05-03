package ru.otus.homework.hw21;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Integer[] array = {1, 2, 1, 1, 2, 2};
        int[] newArray = newArray(array);
        System.out.println(Arrays.toString(newArray));

        check(array);
    }

    public static int[] newArray(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        if (!list.contains(1)) {
            throw new RuntimeException("Error");
        } else {
            logger.info("List contains 1");
        }
        int i = list.lastIndexOf(1);
        List<Integer> result = list.subList(i + 1, list.size());
        int[] newArray = new int[result.size()];
        for (int j = 0; j < newArray.length; j++) {
            newArray[j] = result.get(j);
        }
        return newArray;
    }

    public static boolean check(Integer[] array) {
        Arrays.sort(array);
        List<Integer> list = Arrays.asList(array);

        if (!list.contains(1) || !list.contains(2)) {
            logger.info("List not contains 1 and 2");
            return false;
        }

        List<Integer> result = list.subList(list.indexOf(1), list.lastIndexOf(2) + 1);
        return result.size() == list.size();
    }
}
