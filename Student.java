import java.util.Scanner;

public class Student {
    String name;
    String faculty;
    String programStudi;
    Book[] borrowedBooks = new Book[100];
    int borrowedCount = 0;

    public Student(String name, String faculty, String programStudi) {
        this.name = name;
        this.faculty = faculty;
        this.programStudi = programStudi;
    }

    void displayBooks(Book[] bookList, int bookCount) {
        for (int i = 0; i < bookCount; i++) {
            Book book = bookList[i];
            System.out.println(book.id + ": " + book.judul+ " by " + book.penulis + ", stok: " + book.jumlah);
        }
    }
    void borrowBook(Book[] bookList, int bookCount) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan ID Buku Yang Akan Dipinjam: ");
            String id = scanner.nextLine();
            for (int i = 0; i < bookCount; i++) {
                Book book = bookList[i];
                if (book.id.equals(id)) {
                    if (book.jumlah > 0) {
                        book.jumlah--;
                        borrowedBooks[borrowedCount++] = book;
                        System.out.println("Anda Telah Meminjam Buku " + book.judul + ".");
                        return;
                    } else {
                        System.out.println("Maaf, Buku Ini Sedang Tidak Tersedia.");
                        break;
                    }
                }
                if (i == bookCount - 1) {
                    System.out.println("Buku Dengan ID Tersebut Tidak Ditemukan.");
                }
            }
        }
    }

    void displayBorrowedBooks() {
        if (borrowedCount == 0) {
            System.out.println("Anda Belum Meminjam Buku.");
            return;
        }
        System.out.println("Buku Yang Anda Pinjam:");
        for (int i = 0; i < borrowedCount; i++) {
            Book book = borrowedBooks[i];
            System.out.println(book.id + ": " + book.judul + " by " + book.penulis);
        }
    }

    void logout() {
        System.out.println("Anda Telah Keluar.");
    }
}
