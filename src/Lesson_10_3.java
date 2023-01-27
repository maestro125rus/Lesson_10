import java.util.Arrays;
import java.util.Scanner;
/*������ 3:
��������� ������ https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson7_varargs_overloading/Task5.java
(������ ������� �� ������ ������ �������, �� ��� ����������� �������� ����� ������������ ���������� ����� �� ������ ������� �� ������):

1. �������� ����� ������� ����� � ��������� �����.

+++2. ���������� ����������� ������ �� ����� ����� N ������ ������� �����, ��� N � �����, ��������� ������������� � ����������;

3. �������� ������ ��� ���������� � ���� ������. ���� ���������� � �������� �� ����������� ������ ������ ��� �������.
�������, ��������� ���������� ���� ����������� ������������ ������, � �� ����������� �������. ������ � ��������� ���.

����������: ��� ���� ������, � �� ��������� ��������:)*/

public class Lesson_10_3 {
    public static void main(String[] args) {
        System.out.print("������� �������� ���������� ������� �����: ");
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
        System.out.println("������ �����: " + Arrays.toString(primeNumbers));
        System.out.println("����� ������� ����� = " + sum(primeNumbers));
    }

//    � ������ ������, ���������� ���������� ����� �������� ��� ������ ����� � ������
//    ���������� ������ �������� �������
    static int findNextPrimeNumber(int number, int[] primeNumbers, int currentIndex) {
        boolean isPrime = isPrime(number, primeNumbers, currentIndex);

        if (isPrime) {
            return number;
        }

        number += 2;

        return findNextPrimeNumber(number, primeNumbers, currentIndex);
    }

    //    ����� �������� ����������� ����� �� ��, �������� �� ��� �������
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

//    ������ ���������� �������� ������-�������, �� �������� � ���������� �������
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