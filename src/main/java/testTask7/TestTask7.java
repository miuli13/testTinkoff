package testTask7;

class TestTask7 {
    /**
     * Выводит на экран числа от 1 до 100. Вместо чисел, кратных 3, выводит слово Fizz, вместо чисел, кратных 5 —  слово
     * Buzz. Если число кратно 15 - выводит слово FizzBuzz.
     */
    static void printNumbers(){
        final String fizz = "Fizz";
        final String buzz = "Buzz";
        for (int i = 1; i <= 100; i++){
            if (i%3==0) System.out.print(fizz);
            if (i%5==0) System.out.print(buzz);
            if (i%3!=0&&i%5!=0) System.out.print(i);
            System.out.println();
        }
    }
}
