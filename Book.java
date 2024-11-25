class Book{
    String judul;
    String penulis;
    String penerbit;
    String ISBN;
    String genre;
    int tahunTerbit;
    int jumlahHalaman;
    String sinopsis;
    private boolean ketersediaan;
    int kembalikan;
    Denda denda;

    Book(String judul, String penulis, String penerbit, String ISBN, String genre, int tahunTerbit, int jumlahHalaman, String sinopsis){
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.ISBN = ISBN;
        this.genre = genre;
        this.tahunTerbit = tahunTerbit;
        this.jumlahHalaman = jumlahHalaman;
        this.sinopsis = sinopsis;
        ketersediaan = true;
        this.kembalikan = 30;
    }
    
    void setKetersediaan(boolean status){
        this.ketersediaan = status;
    }

    boolean getKetersediaan(){
        return this.ketersediaan;
    }

    void setKembalikan(int kembalikan){
        this.kembalikan = kembalikan;
    }
}