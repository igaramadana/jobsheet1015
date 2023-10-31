import java.util.Scanner;
public class BioskopWithScanner15 {
    public static void main(String[] args) {
        Scanner sc15 = new Scanner(System.in);
        int baris, kolom;
        String nama;
        String[][] penonton = new String [4][2];

        while (true) {
            System.out.print("Masukkan nama: ");
            nama = sc15.nextLine();
            System.out.print("Masukkan baris: ");
            baris = sc15.nextInt();
            System.out.print("Masukkan Kolom: ");
            kolom = sc15.nextInt();
            sc15.nextLine();

            penonton[baris-1][kolom-1] = nama;

            System.out.print("Input penonton lainnya? (y/n): ");
            String next = sc15.nextLine();

            if (next.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
