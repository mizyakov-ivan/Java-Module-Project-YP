import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void calculator() {
        System.out.println("Введите название товара");
        String nameProduct = scanner.next();
        Main.amountProducts = Main.amountProducts + 1;
        Main.listProducts = Main.listProducts + "\n" + nameProduct;
        System.out.println("Введите стоимость товара в формате в рубли и копейки. Образец 11.11");
        double price = scanner.nextDouble();
        while (price < 0) {
            System.out.println("Ошибка! У товара не может быть отрицательной стоимости. Повторите ввод цены.");
            price = scanner.nextDouble();
        }
        Main.totalPrice = Main.totalPrice + price;
        System.out.println("Товар добавлен.\nДля продолжения введите любой символ и нажмите Enter. " +
                "\nЕсли хотите завершить процесс добавления товара введите 'Завершить'");
        String input = scanner.next();
        if (!input.equalsIgnoreCase("завершить")){
            calculator();
        }
    }
}