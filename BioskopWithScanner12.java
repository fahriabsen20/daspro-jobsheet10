import java.util.Scanner;
public class BioskopWithScanner12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int baris, kolom, menu;
        String nama, next;

        String[][] penonton = new String[4][2];

        boolean jalan = true;
        while (jalan) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Input data penonton");
            System.out.println("2. Tampilkan daftar penonton");
            System.out.println("3. Exit");
            System.out.println("Pilih menu: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    while (true) {
                        System.out.print("Masukkan nama: ");
                        nama = sc.nextLine();

                        while (true) {
                            System.out.println("Masukkan baris: ");
                            baris = sc.nextInt();
                            System.out.println("Masukkan kolom: ");
                            kolom = sc.nextInt();
                            sc.nextLine();

                            if (baris < 1 || baris > penonton.length || kolom < 1 || kolom > penonton[0].length) {
                                System.out.println("Nomor baris/kolom tidak tersedia!");
                                System.out.println("Silahkan masukkan baris dan kolom kembali.");
                            }
                            else if (penonton[baris - 1][kolom - 1] != null) {
                                System.out.println("warning! Kursi sudah terisi oleh " +penonton[baris - 1][kolom - 1] + "!");
                                System.out.println("Silahkan masukkan baris dan kolom kembali.");
                            }
                            else {
                                break;
                            }
                        }
                        penonton[baris-1][kolom-1] = nama;

                        System.out.print("Input penonton lainnya? (y/n): ");
                        next = sc.nextLine();

                        if (next.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    break;
                
                case 2:
                    System.out.println("\n=== DAFTAR PENONTON ===");
                    for (int i = 0; i < penonton.length; i++) {
                        for (int j = 0; j < penonton[i].length; j++) {
                            if (penonton[i][j] == null) {
                                System.out.print("***\t");
                            } else {
                                System.out.print(penonton[i][j] + "\t");
                            }
                        }
                        System.out.println();
                    }
                    break;
                
                case 3:
                    System.out.println("Terima kasih!");
                    jalan = false;
                    break;
                
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
        sc.close();
    }
}
