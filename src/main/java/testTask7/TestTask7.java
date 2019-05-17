package testTask7;

class TestTask7 {

    /**
     * Выводит на экран числа от 1 до 100. Вместо чисел, кратных 3, выводит слово Fizz, вместо чисел, кратных 5 —  слово
     * Buzz. Если число кратно 15 - выводит слово FizzBuzz.
     */
    private final String fizz = "Fizz";
    private final String buzz = "Buzz";

    public void printNumbers() {
        for (int i = 1; i <= 100; i++) System.out.println(fizzBuzzNumber(i));
    }

    String fizzBuzzNumber(int number) {
        if (number % 3 == 0) {
            if (number % 15 == 0) return fizz.concat(buzz);
            return fizz;
        } else if (number % 5 == 0) return buzz;
        else return Integer.toString(number);
    }
}
