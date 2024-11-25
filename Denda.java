import java.util.Scanner;
class Denda{
    User user;
    int denda;

    Denda(User user){
        this.user = user;
    }

    void bayarDenda(Scanner input){
        System.out.println("\nTotal denda yang harus kamu bayar adalah : " + this.denda);
        System.out.print("Masukkan jumlah uang yang kamu miliki : ");
        
        // Anggap aja kita ngisinya jujur hehehehehe
        int uang = input.nextInt();
        if(uang < this.denda){
            System.out.println("Uang yang kamu miliki kurang, denda yang harus dibayarkan : " + (this.denda - uang));
        }else{
            System.out.println("Selamat, denda sudah dibayarkan");
        }
    }

    void cekDenda(User pengguna){
        int totalDenda = 0;
        System.out.println("\nList Buku yang dipinjam");
        for(int i = 0;  i < pengguna.listPinjamanBuku.length; i++){
            System.out.print((i + 1) +". ");
            if(pengguna.listPinjamanBuku[i] == null){
                System.out.println("Belum ada buku");
            }else{
                if(pengguna.listPinjamanBuku[i].kembalikan == 0){
                    System.out.println("Buku " + pengguna.listPinjamanBuku[i].judul + " Telah melewatkan batas peminjaman, Dendan : 10.000");
                    pengguna.listPinjamanBuku[i].denda.denda = 10000;
                    totalDenda += 10000;
                }else{
                    System.out.println("Buku " + pengguna.listPinjamanBuku[i].judul + " Belum melewati batas peminjaman");
                }
            }
        }

        this.denda = totalDenda;
        if(this.denda == 0){
            System.out.println("Selamat, kamu tidak memiliki denda\n");
        }else{
            System.out.println("\nTotal Denda : " + totalDenda);
        }
    }
    void informasiDenda(Scanner input){
        while(true){
            System.out.println("========== Denda ==========");
            System.out.println("1. Bayar Denda");
            System.out.println("2. Cek Denda");
            System.out.println("3. Keluar");

            System.out.print("Pilihan : ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    bayarDenda(input);
                    break;
                case 2:
                    cekDenda(user);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Pilihan tidak valid!!!");
            }
        }
    }
}