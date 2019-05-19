package testTask3;

class TestTask3 {
    /**
     * Напишите функцию, которая будет из входной строки удалять парные, идущие друг за другом буквы в одну и на выходе
     * вернуть строку, которая не будет иметь парных, идущих друг за другом букв.
     */

    static String deletePairedLetters(String in) {
        if (in !=null) {
            String result = "";
            int i = 0;

            while (i < in.length()) {
                if (i != in.length() - 1 && in.charAt(i) == in.charAt(i + 1)) i++;
                else result = result.concat(String.valueOf(in.charAt(i)));
                i++;
            }

            i = 0;

            while (i < result.length()) {
                if (i != result.length() - 1 && result.charAt(i) == result.charAt(i + 1))
                    return deletePairedLetters(result);
                i++;
            }

            return result;
        }
        return null;
    }
}
