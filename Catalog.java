import java.util.Scanner;
class Catalog{
    User pengguna;
    Book[] listBuku = listBuku();
    Catalog(User pengguna){
        this.pengguna = pengguna;
    }
    
    public void listBukuTersedia(Book[] listBuku){
        int i = 0;
        for(Book buku : listBuku){
            if(buku.getKetersediaan()){
                i++;
                System.out.println(i + ". Judul: " + buku.judul + ", Penulis: " + buku.penulis + ", Genre : " + buku.genre + ", Tahun Terbit : " + buku.tahunTerbit);
            }
        }
    }
            
    public void listSeluruhBuku(Book[] listBuku){
        int i = 0;
        for(Book buku : listBuku){
            i++;
            System.out.println(i + ". Judul: " + buku.judul + ", Penulis: " + buku.penulis + ", Genre : " + buku.genre + ", Tahun Terbit : " + buku.tahunTerbit + ", Ketersediaan : " + (buku.getKetersediaan() == true ? "Ada" : "Tidak ada"));
        }
    }
        
    public void informasiBuku(Scanner input){
        while(true){
            System.out.println("\n1. Meminjam Buku");
            System.out.println("2. Kembalikan Buku");
            System.out.println("3. Lihat Seluruh Buku");
            System.out.println("4. Lihat Buku Pinjaman");
            System.out.println("5. Keluar");
            System.out.print("Pilihan : ");
            int pilihan = input.nextInt();

            switch(pilihan){
                case 1:
                pinjemBuku(listBuku, input);
                break;
            case 2:
                System.out.println("");
                kembalikanBuku(input);
                break;
            case 3:
                listSeluruhBuku(listBuku);
                break;
            case 4:
                listBukuPinjaman(listBuku);
                break;
            case 5:
                return;
            default:
                System.out.println("Pilihan tidak valid!!!");
            }
        }
    }

    void listBukuPinjaman(Book[] listBuku){
        System.out.println("\nList Buku yang dipinjam adalah");
        int i = 0;
        for(Book buku : this.pengguna.listPinjamanBuku){
            i++;
            if(this.pengguna.listPinjamanBuku[i - 1] == null){
                System.out.println( i + ". Tidak ada");
            }else{
                System.out.println(i + ". " + buku.judul);
            }
        }
    }

    public  void pinjemBuku(Book[] listBuku, Scanner input){

        System.out.print("Masukkan jumlah buku yang ingin dipinjam (maks 4)  : ");
        int banyak = input.nextInt();
        banyak = banyak > 4 ? 4 : banyak;

        listBukuTersedia(listBuku);
        
        for(int i = 0; i < this.pengguna.listPinjamanBuku.length; i++){
            if(this.pengguna.listPinjamanBuku[i] == null && banyak > 0){
                System.out.print("\nPilih no buku : ");
                int pilihan = input.nextInt();
                listBuku[pilihan - 1].setKetersediaan(false);
                listBuku[pilihan - 1].setKembalikan(30);
                this.pengguna.listPinjamanBuku[i] = listBuku[pilihan - 1];
                System.out.println("Buku " + listBuku[pilihan - 1].judul + " telah ditambahkan");
                banyak--;
            }
        }

        listBukuPinjaman(listBuku);
        if(banyak > 0) System.out.println("Slot peminjaman kamu penuh!!!");
    }

    public void kembalikanBuku(Scanner input){
        if(this.pengguna.listPinjamanBuku  == null){
            System.out.println("Minjem dulu kocak baru balikin bukunya sini!!!");
            return;
        }

        int j = 0;
        for(Book buku : this.pengguna.listPinjamanBuku){
            j++;
            if(this.pengguna.listPinjamanBuku[j - 1] == null){
                System.out.println(j + ". Buku tidak ada");
            }else{
                System.out.println(j + ". Judul: " + buku.judul + ", Penulis: " + buku.penulis + ", Genre : " + buku.genre + ", Tahun Terbit : " + buku.tahunTerbit);
            }
        }
        System.out.print("Masukkan berapa buku yang ingin dikembalikan (angka) : ");
        int banyak = input.nextInt();
        banyak = banyak > this.pengguna.listPinjamanBuku.length? this.pengguna.listPinjamanBuku.length : banyak;

        Book[] dahDiBalikin = new Book[banyak];
        for(int i = 0; i < banyak; i++){
            System.out.print("Masukkan no buku yang ingin dikembalikan (angka) : ");
            int pilihan = input.nextInt() - 1;
            pilihan = pilihan > 4? 4 : pilihan;
            if(this.pengguna.listPinjamanBuku[pilihan] == null){
                System.out.println("Tidak ada buku yang dipinjam!!!");
                return;
            }
            this.pengguna.listPinjamanBuku[pilihan].setKetersediaan(true);
            dahDiBalikin[i] = this.pengguna.listPinjamanBuku[pilihan];
            this.pengguna.listPinjamanBuku[pilihan] = null;
            System.out.println("Buku telah dikembalikan");
        }
        
        int i = 0;
        System.out.println("\nBuku yang sudah dibalikkan : ");
        for(Book buku : dahDiBalikin){
            i++;
            System.out.println(i + ". " + buku.judul);
        }
    }

    public Book[] listBuku(){
        Book[] listBuku = new Book[40];
        listBuku[0] = new Book("Laskar Pelangi", "Andrea Hirata", "Bentang Pustaka", "978-979-769-287-8", "Fiksi", 2005, 528, "Kisah tentang sekelompok anak di Belitung yang berjuang untuk mendapatkan pendidikan.");
        listBuku[1] = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Bloomsbury", "978-0747532699", "Fantasi", 1997, 223, "Petualangan seorang anak penyihir di sekolah sihir Hogwarts.");
        listBuku[2] = new Book("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", "978-0061120084", "Fiksi", 1960, 281, "Kisah tentang ketidakadilan rasial di Amerika Serikat.");
        listBuku[3] = new Book("1984", "George Orwell", "Secker and Warburg", "978-0451524935", "Dystopia", 1949, 328, "Novel tentang masyarakat totaliter di masa depan.");
        listBuku[4] = new Book("Pride and Prejudice", "Jane Austen", "T. Egerton", "978-1503290563", "Romantis", 1813, 279, "Kisah cinta antara Elizabeth Bennet dan Mr. Darcy.");
        listBuku[5] = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", "978-0743273565", "Fiksi", 1925, 180, "Cerita tentang cinta dan ambisi di era Jazz.");
        listBuku[6] = new Book("Moby Dick", "Herman Melville", "Harper & Brothers", "978-1503280786", "Petualangan", 1851, 585, "Perburuan ikan paus raksasa oleh Kapten Ahab.");
        listBuku[7] = new Book("War and Peace", "Leo Tolstoy", "The Russian Messenger", "978-1420954305", "Sejarah", 1869, 1225, "Novel epik yang menggambarkan kehidupan di Rusia selama perang Napoleon.");
        listBuku[8] = new Book("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", "978-0316769488", "Fiksi", 1951, 277, "Cerita seorang remaja yang mencari jati diri.");
        listBuku[9] = new Book("The Hobbit", "J.R.R. Tolkien", "George Allen & Unwin", "978-0007458424", "Fantasi", 1937, 310, "Petualangan Bilbo Baggins untuk menemukan harta karun.");
        listBuku[10] = new Book("The Alchemist", "Paulo Coelho", "HarperOne", "978-0062315007", "Fiksi", 1988, 208, "Kisah perjalanan seorang gembala untuk menemukan takdirnya.");
        listBuku[11] = new Book("The Da Vinci Code", "Dan Brown", "Doubleday", "978-0385504201", "Thriller", 2003, 454, "Misteri yang mengungkap rahasia dalam seni dan sejarah.");
        listBuku[12] = new Book("The Fault in Our Stars", "John Green", "Dutton listBuku", "978-0525478812", "Romantis", 2012, 313, "Kisah cinta dua remaja yang berjuang melawan kanker.");
        listBuku[13] = new Book("Brave New World", "Aldous Huxley", "Chatto & Windus", "978-0060850524", "Dystopia", 1932, 268, "Visi masa depan di mana kebahagiaan dipaksakan.");
        listBuku[14] = new Book("The Picture of Dorian Gray", "Oscar Wilde", "Lippincott's Monthly Magazine", "978-1505290005", "Fiksi", 1890, 254, "Kisah tentang keindahan, moralitas, dan konsekuensi dari kesenangan.");
        listBuku[15] = new Book("Fahrenheit 451", "Ray Bradbury", "Ballantine listBuku", "978-1451673319", "Dystopia", 1953, 158, "Cerita tentang masa depan di mana buku dibakar.");
        listBuku[16] = new Book("The Kite Runner", "Khaled Hosseini", "Riverhead listBuku", "978-1594480003", "Fiksi", 2003, 371, "Persahabatan dan pengkhianatan di Afghanistan.");
        listBuku[17] = new Book("The Road", "Cormac McCarthy", "Alfred A. Knopf", "978-0307387899", "Dystopia", 2006, 287, "Perjalanan seorang ayah dan anak di dunia pasca-apokaliptik.");
        listBuku[18] = new Book("Life of Pi", "Yann Martel", "Knopf Canada", "978-0151008117", "Fiksi", 2001, 319, "Kisah seorang pemuda yang terdampar di lautan bersama harimau.");
        listBuku[19] = new Book("The Chronicles of Narnia", "C.S. Lewis", "Geoffrey Bles", "978-0066238500", "Fantasi", 1950, 767, "Petualangan anak-anak di dunia Narnia.");
        listBuku[20] = new Book("The Hunger Games", "Suzanne Collins", "Scholastic Press", "978-0439023481", "Dystopia", 2008, 374, "Kisah perjuangan hidup di arena pembunuhan.");
        listBuku[21] = new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", "Norstedts Förlag", "978-0307269980", "Thriller", 2005, 465, "Misteri pembunuhan yang melibatkan seorang jurnalis dan hacker.");
        listBuku[22] = new Book("The Secret Garden", "Frances Hodgson Burnett", "Charles Scribner's Sons", "978-1503215072", "Fiksi", 1911, 331, "Kisah tentang menemukan keajaiban di taman tersembunyi.");
        listBuku[23] = new Book("The Bell Jar", "Sylvia Plath", "Heinemann", "978-0060837020", "Fiksi", 1963, 288, "Cerita tentang perjuangan melawan depresi.");
        listBuku[24] = new Book("The Outsiders", "S.E. Hinton", "Viking Press", "978-0142407332", "Fiksi", 1967, 192, "Kisah tentang pertempuran antara dua kelas sosial.");
        listBuku[25] = new Book("The Handmaid's Tale", "Margaret Atwood", "McClelland and Stewart", "978-0385490818", "Dystopia", 1985, 311, "Cerita tentang dunia di mana wanita kehilangan hak-hak mereka.");
        listBuku[26] = new Book("The Road Less Traveled", "M. Scott Peck", "Simon & Schuster", "978-0684846593", "Non-Fiksi", 1978, 300, "Panduan untuk pertumbuhan pribadi dan spiritual.");
        listBuku[27] = new Book("The 7 Habits of Highly Effective People", "Stephen R. Covey", "Free Press", "978-0743269513", "Non-Fiksi", 1989, 381, "Panduan untuk mencapai efektivitas pribadi dan profesional.");
        listBuku[28] = new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "Harvill Secker", "978-0099590088", "Non-Fiksi", 2011, 443, "Sejarah manusia dari prasejarah hingga modern.");
        listBuku[29] = new Book("Educated", "Tara Westover", "Random House", "978-0399590504", "Memoir", 2018, 334, "Kisah seorang wanita yang mengejar pendidikan tanpa pendidikan formal.");
        listBuku[30] = new Book("Becoming", "Michelle Obama", "Crown Publishing Group", "978-1524763138", "Memoir", 2018, 448, "Memoir mantan Ibu Negara AS.");
        listBuku[31] = new Book("The Immortal Life of Henrietta Lacks", "Rebecca Skloot", "Crown Publishing Group", "978-1400052189", "Non-Fiksi", 2010, 381, "Kisah kehidupan dan sel-sel Henrietta Lacks yang mengubah dunia medis.");
        listBuku[32] = new Book("Where the Crawdads Sing", "Delia Owens", "G.P. Putnam's Sons", "978-0735219090", "Fiksi", 2018, 368, "Kisah tentang seorang gadis yang tumbuh di rawa-rawa Carolina.");
        listBuku[33] = new Book("The Silent Patient", "Alex Michaelides", "Celadon listBuku", "978-1250301697", "Thriller", 2019, 336, "Misteri tentang seorang wanita yang berhenti berbicara setelah membunuh suaminya.");
        listBuku[34] = new Book("Anxious People", "Fredrik Backman", "Atria listBuku", "9781501160837", "Fiksi", 2020, 300, "Kisah tentang sekelompok orang yang terjebak dalam situasi penyanderaan.");
        listBuku[35] = new Book("The Vanishing Half", "Brit Bennett", "Riverhead listBuku", "9780525536963", "Fiksi", 2020, 352, "Kisah tentang dua saudara kembar yang memilih jalan hidup berbeda.");
        listBuku[36] = new Book("Circe", "Madeline Miller", "Little, Brown and Company", "9780316334754", "Fantasi", 2018, 400, "Kisah tentang penyihir Circe dari mitologi Yunani.");
        listBuku[37] = new Book("The Midnight Library", "Matt Haig", "Viking", "9780525559474", "Fiksi", 2020, 304, "Kisah tentang pilihan hidup dan kesempatan kedua.");
        listBuku[38] = new Book("Normal People", "Sally Rooney", "Faber & Faber", "9780571334650", "Fiksi", 2018, 273, "Kisah cinta yang rumit antara dua remaja Irlandia.");
        listBuku[39] = new Book("Daisy Jones & The Six", "Taylor Jenkins Reid", "Ballantine listBuku", "9781524798652", "Fiksi", 2019, 368, "Kisah fiktif tentang band rock di tahun 1970-an.");
        return listBuku;
    }
}