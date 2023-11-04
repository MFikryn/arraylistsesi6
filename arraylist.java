import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Perpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.println("======================================================================================");
        System.out.println("Daftar Buku Java yang Tersedia");
        System.out.println("======================================================================================");
        System.out.println("No Judul Pengarang Penerbit Tahun Kategori");
        System.out.println("======================================================================================");

        for (int i = 0; i < 3; i++) {
            Book book = new Book();

            System.out.print((i + 1) + ") ");
            System.out.print("judul : ");
            book.setTitle(scanner.nextLine());

            System.out.print("Author : ");
            book.setAuthor(scanner.nextLine());

            System.out.print("Penerbit : ");
            book.setPublisher(scanner.nextLine());

            System.out.print("Kategori : ");
            book.setCategory(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Tahun : ");
            book.setYear(scanner.nextInt());
            scanner.nextLine();

            library.addBook(book);
        }

        System.out.println("======================================================================================");
        System.out.println("Daftar Buku Java yang Tersedia");
        System.out.println("======================================================================================");
        System.out.println("No Judul Pengarang Penerbit Tahun Kategori");
        System.out.println("======================================================================================");

        int j = 0;
        for (Book book : library.getBooks()) {
            j++;
            System.out.println((j) + " " + book);
        }

        System.out.println("======================================================================================");
        System.out.println("Statistik Buku");
        System.out.println("======================================================================================");
        System.out.println("Jumlah buku yang tersedia : " + library.getBooks().size());
        System.out.println("Buku Teknik : " + library.countCategory(1));
        System.out.println("Buku Manajemen : " + library.countCategory(2));
        System.out.println("Buku Fiksi : " + library.countCategory(3));
        System.out.println("Buku Lainnya : " + library.countCategory(4));
        System.out.println("Buku Lawas : " + library.countOldBooks());
        System.out.println("Buku Baru : " + library.countNewBooks());

        scanner.close();
    }
}

class Library {
    private java.util.List<Book> books;

    public Library() {
        books = new java.util.ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public java.util.List<Book> getBooks() {
        return books;
    }

    public int countCategory(int category) {
        int count = 0;
        for (Book book : books) {
            if (book.getCategory() == category) {
                count++;
            }
        }
        return count;
    }

    public int countOldBooks() {
        int count = 0;
        for (Book book : books) {
            if (book.getYear() < LocalDate.now().getYear()) {
                count++;
            }
        }
        return count;
    }

    public int countNewBooks() {
        int count = 0;
        for (Book book : books) {
            if (book.getYear() >= LocalDate.now().getYear()) {
                count++;
            }
        }
        return count;
    }
}