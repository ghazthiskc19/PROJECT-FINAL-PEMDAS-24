import java.util.Scanner;
class RuanganBaca{
    User pengguna;
    String noRuangan;
    int kapasitas;
    int[][] listReservasi;
    int reservasiX;
    int reservasiY;

    RuanganBaca(String noRuangan, int[][] listReservasi){
        this.noRuangan = noRuangan;
        this.listReservasi = listReservasi;
        this.kapasitas = listReservasi.length * listReservasi[0].length;
    }

    void informasiRuanganBaca(Scanner input){
        System.out.println("\nNo Ruangan : " + this.noRuangan);
        System.out.println("Kapasitas : " + this.kapasitas);

        while(true){
            System.out.println("\nPilih menu :");
            System.out.println("1. Reservasi Ruangan");
            System.out.println("2. Batalkan Reservasi");
            System.out.println("3. Keluar");
            System.out.print("Pilihan : ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    reservasiTempat(input);
                    break;
                case 2:
                    batalReservasi();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Pilihan menu yang valid");
            }
            for(int i = 0; i < this.pengguna.listPinjamanBuku.length; i++) {
                Book buku = this.pengguna.listPinjamanBuku[i];
                buku.kembalikan--;
            }
        }
    }
    
    void listReservasiTempat() { 
        for(int i = 0; i < listReservasi.length; i++){
            for(int j = 0; j < listReservasi[i].length; j++){
                System.out.print("[" + listReservasi[i][j] + "]   ");
            }
            System.out.println();
            System.out.println();
        }

        System.out.println("Note : 0 = Kosong, 1 = Terisi");
    }
    void reservasiTempat(Scanner input){
        System.out.println("");
        listReservasiTempat();
        System.out.print("\nMasukkan posisi tempat yang ingin di reservasi (x,y) : ");
        reservasiX = input.nextInt() - 1;
        reservasiY = input.nextInt() - 1;

        if(listReservasi[reservasiY][reservasiX] == 0){
            System.out.println("Tempat yang dipilih tersedia");
            listReservasi[reservasiY][reservasiX] = 2;
            listReservasiTempat();
            System.out.println("Note : 2 = Tempat yang dipilih");
        }else{
            System.out.println("Tempat yang dipilih sedang terisi");
        }
        for(int i = 0; i < this.pengguna.listPinjamanBuku.length; i++) {
            Book buku = this.pengguna.listPinjamanBuku[i];
            buku.kembalikan--;
        }
    }

    void batalReservasi(){
        if(listReservasi[reservasiY][reservasiX] == 2){
            System.out.println("\nReservasi berhasil dibatalkan");
            listReservasi[reservasiY][reservasiX] = 0;
            listReservasiTempat();
        }else{
            System.out.println("Tidak ada reservasi di posisi tersebut");
        }
    }
}