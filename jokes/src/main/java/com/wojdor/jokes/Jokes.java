package com.wojdor.jokes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Jokes {

    private List<String> allJokes = new ArrayList<>();

    public Jokes() {
        initAllJokes();
    }

    public String getRandomJoke() {
        Random random = new Random();
        int index = random.nextInt(allJokes.size());
        return allJokes.get(index);
    }

    private void initAllJokes() {
        allJokes = Arrays.asList(
                "Q: How many programmers does it take to change a light bulb?\n" +
                        "A: None. It's a hardware problem.",
                "Q: Why do programmers always mix up Halloween and Christmas?\n" +
                        "A: Because 31 OCT = 25 DEC.",
                "There are 10 types of people in the world: those who understand binary and those who don't.",
                "Q: What does a proud computer call his little son?\n" +
                        "A: A microchip off the old block.",
                "Q: What is another name for a computer virus?\n" +
                        "A: A terminal illness.",
                "Q: What do you get if you take your computer to an ice rink?\n" +
                        "A: A slipped disk.",
                "Q: How can you tell if a computer geek is an extrovert?\n" +
                        "A: They stare at your shoes when you talk instead of their own.",
                "Q: Why did the programmer use the entire bottle of shampoo during one shower?\n" +
                        "A: Because the bottle said \"Lather, Rinse, Repeat.\"",
                "Q: How does a network administrator nerd greet people who come to his house?\n" +
                        "A: Welcome to 127.0.0.1.",
                "Q: Why can't cats work on the computer?\n" +
                        "A: They get too distracted chasing the mouse around.",
                "Windows Vista supports real multitasking - it can boot and crash simultaneously.",
                "The box said 'Requires Windows 95 or better'. So I installed Linux.",
                "A computer once beat me at chess, but it was no match for me at kick boxing."
        );
    }
}
