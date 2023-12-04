import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    static int amountPeople=0; // количество людей
    static double totalPrice = 0; // итоговая стоимость товаров
    static int amountProducts= 0; // количество товаров
    static String listProducts = ""; // список товаров
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while (amountPeople <= 1) {
            try {
                System.out.println("Введите количество человек:");
                amountPeople = scanner.nextInt();

                if (amountPeople == 1) {
                    System.out.println("Нет смысла делить счет, укажите другое значение.");
                } else if (amountPeople < 1) {
                    System.out.println("Ошибка: некорректное значение для подсчёта.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: некорректный формат ввода. Введите целое число.");
                scanner.nextLine();
            }
        }
        Calculator.calculator();
        System.out.printf("Сумма которую необходимо поделить равна: %.2f\n", totalPrice);
        System.out.println("Количество человек: " + amountPeople + "\n" + "Количество добавленных товаров: "+
                amountProducts + "\n" + "Добавленные товары:" + listProducts);
        SplitCheck.formatter();
    }
}