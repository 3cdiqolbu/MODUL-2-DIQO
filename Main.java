import java.util.Scanner;
public class Main {
    String Book, User, Student;
    Book[] bookList = new Book[100];
    int bookCount = 0;
    User[] userStudent = new User[100];
    int studentCount = 0;
    Admin admin = new Admin();
    Student student;

    Main() {
        bookList[bookCount++] = new Book("1", "Satu Hari Mencintainya", "MR.LOVERMAN", 10);
        bookList[bookCount++] = new Book("2", "Dua Hari Mencintainya", "MR.LOVERMAN", 15);
        bookList[bookCount++] = new Book("3", "Berkali-kali Mencintainya", "MR.LOVERMAN", 20);
        bookList[bookCount++] = new Book("4", "Sesedih Itu Aku", "MR.SADNESS", 20);
        bookList[bookCount++] = new Book("5", "Sesedih Itu Aku Dan Kamu", "MR.SADNESS", 20);
    }

    void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Student");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3) : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    if (loginAdmin()) {
                        menuAdmin();
                    } else {
                        System.out.println("Username Atau Password Salah!!!.");
                    }
                    break;
                case 2:
                    if (inputNim()) {
                        menuStudent();
                    } else {
                        System.out.println("NIM Tidak Ditemukan!!!.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("GOODBYE SUMMER!!!");
                    System.out.println();
            }
        }
    }

    boolean loginAdmin() {
        Scanner scanner = new Scanner(System.in);
        String username, password;
        do {
            System.out.print("Masukkan Username : ");
            username = scanner.nextLine();
            System.out.print("Masukkan Password : ");
            password = scanner.nextLine();
            if (!admin.adminUsername.equals(username) || !admin.adminPassword.equals(password)) {
                System.out.println("Username Atau Password Salah!!!.\nSilakan Coba Lagi :).");
            }
        } while (!admin.adminUsername.equals(username) || !admin.adminPassword.equals(password));
        return true;
    }

    boolean inputNim() {
        Scanner scanner = new Scanner(System.in);
        String nim;
        do {
            System.out.print("Masukkan NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM Tidak Valid.");
            }
        } while (nim.length() != 15);
        return checkNim(nim);
    }

    boolean checkNim(String nim) {
        for (int i = 0; i < studentCount; i++) {
            if (userStudent[i].nim.equals(nim)) {
                student = new Student(userStudent[i].nama, userStudent[i].fakultas, userStudent[i].programStudi);
                return true;
            }
        }
        return false;
    }

    void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Tambah Student");
            System.out.println("2. Tampilkan Student");
            System.out.println("3. Kembali");
            System.out.print("Pilih opsi (1-3) : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    admin.addStudent();
                    userStudent = admin.studentList;
                    studentCount = admin.studentCount;
                    break;
                case 2:
                    admin.displayStudents();
                    break;
                case 3:
                    return;

                default:
                    System.out.println("MBOHH WESS!!!");
            }
        }
    }

    void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("===== Student Menu =====");
            System.out.println("1. Tampilkan Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Tampilkan Buku Yang Dipinjam");
            System.out.println("4. Logout");
            System.out.print("Pilih opsi (1-4) : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    student.displayBooks(bookList, bookCount);
                    break;
                case 2:
                    student.displayBorrowedBooks();
                    break;
                case 3:
                    System.out.println("MBOHH RANGERTI AKU");
                    break;
                case 4:
                    student.logout();
                    return;
                default:
                    System.out.println("OKAY DEHH");
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}