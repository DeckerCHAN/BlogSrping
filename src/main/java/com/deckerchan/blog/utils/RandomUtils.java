package com.deckerchan.blog.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomUtils {
   private final static List<String> wordList = Arrays.asList("lorem ipsum dolor sit amet consectetur adipisicing elit Amet numquam aspernatur eum quasi sapiente nesciunt Voluptatibus sit repellat sequi itaque deserunt dolores in nesciunt illum tempora ex quae Nihil dolorem".split(" "));


    public static String randomName(int countFrom, int countTo, String termintaor){
        Collections.shuffle(wordList);
        return   wordList.subList(0, countFrom + new Random().nextInt(countTo)).stream().collect(Collectors.joining(termintaor));
    }
}
