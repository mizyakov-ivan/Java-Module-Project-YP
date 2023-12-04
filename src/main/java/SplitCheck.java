public class SplitCheck {
    public static void formatter(){
        double split = Main.totalPrice / Main.amountPeople;
        String format = "Каждый человек должен заплатить поровну, а именно: %.2f %s";
        int roundedSplit = (int)Math.floor(split);
        int preLastDigit = roundedSplit % 100 / 10;
        int lastDigit = roundedSplit % 10;
        if (preLastDigit == 1){
            String rubles = "рублей";
            System.out.println(String.format(format, split, rubles));
        } else {
            String rubles;
            switch (lastDigit) {
                case 1:
                    rubles = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    rubles = "рубля";
                    break;
                default:
                    rubles = "рублей";
                    break;
            }System.out.println(String.format(format, split, rubles));
        }
    }
}