public class User{
    String nama;
    int id;
    String email;
    Book[] listPinjamanBuku = new Book[4];
    
    User(String nama, int id){
        this.nama = nama;
        this.id = id;
    }

    User(String nama, int id, String email){
        this.nama = nama;
        this.id = id;
        this.email = email;
    }
}
