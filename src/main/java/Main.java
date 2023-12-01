import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    static int amountPeople; // количество людей
    static double totalPrice = 0; // итоговая стоимость товаров
    static int amountProducts= 0; // количество товаров
    static String listProducts = ""; // список товаров
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int amountPeople = 0;
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
        System.out.println("Сумма которую необхоидмо поделить равна: "+ totalPrice);
        System.out.println("Количество человек: " + amountPeople);
        System.out.println("Количество добавленных товаров: "+ amountProducts);
        System.out.println("Добавленные товары:" + listProducts);
        SplitCheck.formatter();
    }

    public static class Calculator {
        public static void calculator() {
            System.out.println("Введите название товара");
            String nameProduct = scanner.next();
            amountProducts = amountProducts +1;
            listProducts = listProducts + "\n" + nameProduct;
            System.out.println("Введите стоимость товара в формате в рубли и копейки. Образец 11.11");
            double price = scanner.nextDouble();
            totalPrice = totalPrice + price;
            System.out.println("Товар добавлен.\nДля продолжения введите любой символ и нажмите Enter. " +
                    "\nЕсли хотите завершить процесс добавления товара введите 'Завершить'");
            String input = scanner.next();
            if (!input.equalsIgnoreCase("завершить")){
                calculator();
            }
        }
    }
    public static class SplitCheck {
        public static void formatter(){
            double split = totalPrice / amountPeople;
            String format = "Каждый человек должен заплатить поровну, а именно: %.2f %s";
            int roundedSplit = (int)Math.floor(split);
            int preLastDigit = roundedSplit % 100 / 10;
            int lastDigit = roundedSplit %10;
            if (preLastDigit == 1){
                String rubles = "рублей";
                System.out.println(String.format(format, split, rubles));
            }
            switch (lastDigit) {
                case 1:{
                    String rubles = "рубль";
                    System.out.println(String.format(format, split, rubles));}
                break;
                case 2:
                case 3:
                case 4: {
                    String rubles = "рубля";
                    System.out.println(String.format(format, split, rubles));}
                break;
                default:
                    String rubles = "рублей";
                    System.out.println(String.format(format, split, rubles));}
        }
    }
}
