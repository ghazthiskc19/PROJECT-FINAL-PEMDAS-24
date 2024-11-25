import java.util.Scanner;
public class MGHAZYH_main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Selamat Datang!!, di Perpustakaan FILKOM UB");
        System.out.println("""
██████╗░███████╗██████╗░██████╗░██╗░░░██╗░██████╗████████╗░█████╗░██╗░░██╗░█████╗░░█████╗░███╗░░██╗
██╔══██╗██╔════╝██╔══██╗██╔══██╗██║░░░██║██╔════╝╚══██╔══╝██╔══██╗██║░██╔╝██╔══██╗██╔══██╗████╗░██║
██████╔╝█████╗░░██████╔╝██████╔╝██║░░░██║╚█████╗░░░░██║░░░███████║█████═╝░███████║███████║██╔██╗██║
██╔═══╝░██╔══╝░░██╔══██╗██╔═══╝░██║░░░██║░╚═══██╗░░░██║░░░██╔══██║██╔═██╗░██╔══██║██╔══██║██║╚████║
██║░░░░░███████╗██║░░██║██║░░░░░╚██████╔╝██████╔╝░░░██║░░░██║░░██║██║░╚██╗██║░░██║██║░░██║██║░╚███║
╚═╝░░░░░╚══════╝╚═╝░░╚═╝╚═╝░░░░░░╚═════╝░╚═════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝

███████╗██╗██╗░░░░░██╗░░██╗░█████╗░███╗░░░███╗  ██╗░░░██╗██████╗░
██╔════╝██║██║░░░░░██║░██╔╝██╔══██╗████╗░████║  ██║░░░██║██╔══██╗
█████╗░░██║██║░░░░░█████═╝░██║░░██║██╔████╔██║  ██║░░░██║██████╦╝
██╔══╝░░██║██║░░░░░██╔═██╗░██║░░██║██║╚██╔╝██║  ██║░░░██║██╔══██╗
██║░░░░░██║███████╗██║░╚██╗╚█████╔╝██║░╚═╝░██║  ╚██████╔╝██████╦╝
╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚═╝░╚════╝░╚═╝░░░░░╚═╝  ░╚═════╝░╚═════╝░
                """);
        System.out.print("Nama panggilan : ");
        String nama = input.nextLine();
        int randomId = (int) (Math.random() * 8);
        
        User pegguna1 = new User(nama, randomId);
        Catalog catalog = new Catalog(pegguna1);

        int[][] ukuranRuangan = new int[5][5];
        RuanganBaca ruangBaca = new RuanganBaca("Filkom UB", ukuranRuangan);
        Denda denda = new Denda(pegguna1);

        while(true){
            System.out.println("\nHalo " + pegguna1.nama + " Apa yang hendak kamu lakukan?");
            System.out.println("1. Informasi Buku");
            System.out.println("2. Informasi Ruangan Baca");
            System.out.println("3. Informasi Denda");
            System.out.println("4. Keluar");
            System.out.print("Pilihan : ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    catalog.informasiBuku(input);
                    break;
                case 2:
                    ruangBaca.informasiRuanganBaca(input);
                    break;
                case 3:
                    denda.informasiDenda(input);
                    break;
                case 4:
                    System.out.println("Terimakasih Telah datang ke perpustakaan FILKOM UB ;)");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!!!");
            }
        }        
    }
}