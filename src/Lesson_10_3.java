import java.util.Arrays;
import java.util.Scanner;
/*Задача 3:
Используя задачу https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson7_varargs_overloading/Task5.java
(можете сделать на основе своего решения, но для наглядности удобства новых возможностей рекомендую взять за основу решение по ссылке):

1. Вынесите поиск простых чисел в отдельный класс.

+++2. Реализуйте возможность вывода на экран суммы N первых простых чисел, где N – число, введенное пользователем с клавиатуры;

3. Вынесите нужные вам переменные в поля класса. Если необходимо – сделайте их константами уровня класса или объекта.
Помните, константа ссылочного типа гарантирует неизменность ссылки, а не содержимого объекта. Массив – ссылочный тип.

Примечание: это одна задача, а не различные варианты:)*/

public class Lesson_10_3 {
    public static void main(String[] args) {
        System.out.print("Введите желаемое количество простых чисел: ");
        Scanner scNumOfPrimes = new Scanner(System.in);

        int[] primeNumbers = new int[scNumOfPrimes.nextInt()];
        scNumOfPrimes.close();

        for (int i = 0; i < primeNumbers.length; i++) {
            if (i == 0) {
                primeNumbers[i] = 2;
            } else {
                int addingValue =  i==  1 ?1 : 2;
                int number = primeNumbers[i - 1] + addingValue;
                primeNumbers[i] = findNextPrimeNumber(number, primeNumbers, i);
            }
        }
        System.out.println("Список чисел: " + Arrays.toString(primeNumbers));
        System.out.println("Сумма простых чисел = " + sum(primeNumbers));
    }

//    В данном случае, рекурсивно реализован вызов проверки для нового числа в рамках
//    заполнения одного элемента массива
    static int findNextPrimeNumber(int number, int[] primeNumbers, int currentIndex) {
        boolean isPrime = isPrime(number, primeNumbers, currentIndex);

        if (isPrime) {
            return number;
        }

        number += 2;

        return findNextPrimeNumber(number, primeNumbers, currentIndex);
    }

    //    Метод проверки конкретного числа на то, является ли оно простым
    static boolean isPrime(int number, int[] primeNumbers, int currentIndex) {
        int j = 0;
        boolean isPrime = true;

        while (isPrime && j < currentIndex && number / primeNumbers[j] > 1) {
            if (number % primeNumbers[j] == 0) {
                isPrime = false;
            } else {
                j++;
            }
        }
        return isPrime;
    }

//    Логика реализации удобного метода-обертки, по аналогии с предыдущей задачей
    static int sum(int[] numbers) {
        return sum(numbers, 0);
    }

    static int sum(int[] numbers, int i) {
        if (i == numbers.length - 1) {
            return numbers[i];
        }

        return numbers[i] + sum(numbers, i + 1);
    }
}