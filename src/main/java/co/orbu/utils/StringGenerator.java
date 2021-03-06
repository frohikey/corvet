package co.orbu.utils;

import java.util.Random;

public class StringGenerator {

    private static final int DEFAULT_STRING_LENGTH = 8;
    private static final Random RANDOM = new Random();

    private StringGenerator() {
    }

    public static String getRandomString() {
        return getRandomString(DEFAULT_STRING_LENGTH);
    }

    public static String getRandomString(int length) {

        char[] vowels = {'a', 'e', 'y', 'o', 'u'};
        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
        char[] numbers = {'0', '2', '3', '4', '5', '6', '7', '8', '9'};

        final int vowelsCount = vowels.length;
        final int consonantsCount = consonants.length;
        final int numbersCount = numbers.length;

        String result = "";

        // values:
        // 0 - generate one consonant
        // 1 - generate one vowel
        // 2 - generate vowel or number
        byte mode = 0;

        for (int i = 0; i < length; i++) {
            switch (mode) {
                default:
                case 0:
                    result += consonants[RANDOM.nextInt(consonantsCount)];
                    mode = 1;
                    break;

                case 1:
                    result += vowels[RANDOM.nextInt(vowelsCount)];
                    mode = 2;
                    break;

                case 2:
                    if (RANDOM.nextBoolean()) {
                        result += vowels[RANDOM.nextInt(vowelsCount)];
                    } else {
                        result += numbers[RANDOM.nextInt(numbersCount)];
                    }

                    mode = 0;
                    break;
            }
        }

        return result;
    }
}
