package task3;

import java.util.Scanner;

public class Main {

    // метод шифрования
    public static String encrypt(String text, int key) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)(chars[i] + key);
        }

        return new String(chars);
    }

    // метод расшифрования
    public static String decrypt(String text, int key) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)(chars[i] - key);
        }

        return new String(chars);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();

        System.out.println("Введите ключ:");
        int key = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        String encrypted = encrypt(text, key);

        System.out.println("Текст после преобразования: " + encrypted);

        while (true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String answer = scanner.nextLine();

            if (answer.equals("y")) {
                String decrypted = decrypt(encrypted, key);
                System.out.println("Расшифрованный текст: " + decrypted);
                break;
            }
            else if (answer.equals("n")) {
                System.out.println("До свидания!");
                break;
            }
            else {
                System.out.println("Введите корректный ответ");
            }
        }
    }
}

