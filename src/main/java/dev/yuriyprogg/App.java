package dev.yuriyprogg;

import java.util.Scanner;

/**
 * CalculatorJava
 */
public class App {
	public static void main(String[] args) {
		System.out.println("====> Калькулятор на Java <=====\n\tвысчитовает римские и арабские числа\n");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите первое число: ");
		String inputFirstNumber = scanner.next();
		System.out.print("Введите второе число: ");
		String inputSecondNumber = scanner.next();
		System.out.print("Выберите операцию (+, -, *, /): ");
		OperationsEnum operation = OperationsEnum.fromValue(scanner.next());
		scanner.close();

		int firstNumber, secondNumber, result;
		boolean isRoman = RomanNumerals.isRoman(inputFirstNumber) && RomanNumerals.isRoman(inputSecondNumber);
		boolean isArabic = !RomanNumerals.isRoman(inputFirstNumber) && !RomanNumerals.isRoman(inputSecondNumber);

		if (isRoman) {
			firstNumber = RomanNumerals.parseToInt(inputFirstNumber);
			secondNumber = RomanNumerals.parseToInt(inputSecondNumber);
		} else if (isArabic) {
			firstNumber = Integer.parseInt(inputFirstNumber);
			secondNumber = Integer.parseInt(inputSecondNumber);
		} else {
			System.out.println("Введённые числа не являются однотипными римскими или арабскими числами.");
			return;
		}

		switch (operation) {
			case ADD:
				result = firstNumber + secondNumber;
				break;
			case SUB:
				result = firstNumber - secondNumber;
				break;
			case MUL:
				result = firstNumber * secondNumber;
				break;
			case DIV:
				result = firstNumber / secondNumber;
				break;

			default:
				System.out.println("Операция не найдена.");
				return;
		}

		if (isRoman)
			System.out.println("Результат: " + RomanNumerals.parseToRoman(result));
		else
			System.out.println("Результат: " + result);

	}
}
