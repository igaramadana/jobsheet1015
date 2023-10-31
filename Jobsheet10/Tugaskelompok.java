import java.util.Scanner;
public class demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] newRek = new String[4][2];
        int[] id = {01, 02, 03, 04, 05};
        int[] noRek = {112233, 334455, 556677, 889911, 123456};
        String[] nama = {"Annisa", "Iga", "Firman", "Dzaki", "Alfin"};
        int[] pin = {1122, 2233, 3344, 4455, 5566};
        String[] alamat = {"Nganjuk", "Dampit", "Blitar", "Klojen", "Sukun"};
        int[] saldo = {1000000, 5000000, 3500000, 2500000, 4000000};
        boolean login = false;

        System.out.print("Masukkan PIN anda: ");
        int pinLogin = input.nextInt();

        for (int i = 0; i < pin.length; i++) {
            if (pinLogin == pin[i]) {
                login = true;
                break;
            }
        }

        if (login) {
            do {
                System.out.println("=============================================");
                System.out.println("""
                        Silahkan pilih menu di bawah ini :
                        1. Data Nasabah
                        2. Cek Saldo
                        3. Tarik Tunai
                        4. Daftar Antrian
                        5. Cek Antrian
                        0. Keluar""");
                System.out.print("Menu : ");
                int menu = input.nextInt();

                switch (menu) {
                    case 1 :
                    System.out.println("=============================================");
                    System.out.println("|             Menu Data Nasabah             |");
                    System.out.println("=============================================");
                    System.out.print("Masukkan PIN Nasabah: ");
                    int pinNasabah = input.nextInt();
                
                    int index = 0;
                    for (int i = 0; i < pin.length; i++) {
                        if (pinNasabah == pin[i]) {
                            index = i;
                        }
                    }
                
                    if (index != -1) {
                        System.out.println("Nama\t|No.Rek\t\t|ID Pengguna\t|\tAlamat\t|");
                        System.out.println("---------------------------------------------------------");
                        System.out.print(nama[index] + "\t|");
                        System.out.print("\t" + noRek[index] + "\t|");
                        System.out.print("\t" + id[index] + "\t|");
                        System.out.print("\t" + alamat[index] + "\t|");
                        System.out.println();
                    } else {
                        System.out.println("PIN Nasabah tidak valid.");
                    }
                        break;
                    case 2 :
                    System.out.println("=============================================");
                    System.out.println("|              Menu Cek Saldo               |");
                    System.out.println("=============================================");
                    System.out.print("Masukkan nomor rekening anda : ");
                    int no = input.nextInt();
                
                    int test = 0;
                        for (int i = 0; i < noRek.length; i++) {
                            if (no == noRek[i]) {
                                test = 1;
                                System.out.println("Nama\t\t: " + nama[i]);
                                System.out.println("Saldo anda\t: Rp. " + saldo[i]);
                                System.out.println("=============================================");
                                System.out.println();
                            }
                        }
                        if (test == 0) {
                            System.out.println("Nomor rekening tidak valid");
                            System.out.println("=============================================");
                            System.out.println();
                            return;
                        }
                        break;
                    case 3 :
                    System.out.println("=============================================");
                    System.out.println("|              Menu Tarik Tunai             |");
                    System.out.println("=============================================");
                    System.out.print("Masukkan nomor rekening anda : ");
                    int ts = input.nextInt();
                
                    test = 0;
                    for (int i = 0; i < noRek.length; i++) {
                        if (ts == noRek[i]) {
                            test = 1;
                            System.out.print("Masukkan jumlah saldo yang ingin ditarik: ");
                            int jumlahTarik = input.nextInt();
                            
                            if (saldo[i] >= jumlahTarik) {
                                saldo[i] -= jumlahTarik; 
                                System.out.println("Anda telah berhasil melakukan penarikan.");
                                System.out.println("Nama\t\t: " + nama[i]);
                                System.out.println("Sisa saldo anda\t: Rp. " + saldo[i]);
                                System.out.println("=============================================");
                                System.out.println();
                            } else {
                                System.out.println("================================================");
                                System.out.println("Saldo tidak mencukupi untuk melakukan penarikan.");
                                System.out.println("================================================");
                                System.out.println();
                            }
                            break;
                        }
                    }
                
                    if (test == 0) {
                        System.out.println("Nomor rekening tidak valid");
                        System.out.println("=============================================");
                        System.out.println();
                    }
                    case 4 :
                    System.out.print("Masukkan Nama: ");
                    String newNama = input.next();
                    System.out.print("Masukkan Antrian: ");
                    int newId = input.nextInt();
                    System.out.print("Masukkan Baris: ");
                    int newRek2 = input.nextInt();
                    
                    if (newId >= 1 && newId <= 4 && newRek2 >= 1 && newRek2 <= 2) {
                        if (newRek[newId - 1][newRek2 - 1] == null) {
                            newRek[newId - 1][newRek2 - 1] = newNama;
                            System.out.println("Data Berhasil diinput");
                            System.out.println();
                        } else {
                            System.out.println("Antrian sudah tersedia");
                        }
                    } else {
                        System.out.println("Antrian tidak tersedia. Harap masukkan nilai yang valid");
                    }
                    case 5 : 
                    System.out.println();
                    System.out.println("Daftar antrian:");
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 2; j++) {
                            if (newRek[i][j] != null) {
                                System.out.println("Antrian ke-" + (i+1) + " baris ke-"+ (j+1) + ": " + String.join(", ", newRek[i][j]));
                            } else {
                                System.out.println("Antrian ke-" + (i+1) + " baris ke-" + (j+1) +": " + String.join(", ", "Kosong"));
                            }
                        }
                    }
                    break;
                    default : System.out.println("Menu tidak valid");
                } break;
            } while (login);
            System.out.println("=============================================");
            
        } else {
            System.out.println("Anda Memasukkan PIN yang salah, Silahkan Coba Lagi...");
    }
}
}

