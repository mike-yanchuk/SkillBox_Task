public class Main {
    public static int b = 1;
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());


        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        for (int i = 0; i <= 65535 ; i++) {
            char c = (char) i;
            if(c == 1025 || c <= 1103 && c >= 1040 || c == 1105) {

                System.out.println(b + ": " + c);
                b = b + 1;
            }

        }
    }
}
