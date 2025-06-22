import java.util.Arrays;
import java.util.Comparator;

class Book{
    int bookId;
    String title;
    String author;
    
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " - " + title + " - " + author;
    }
}

public class LibraryManagementSystem{
    Book[] books;
    int count;

    public LibraryManagementSystem(int size){
        books = new Book[size];
        count = 0;
    }

    public void addBooks(Book book){
        if(count < books.length){
            books[count++] = book;
            System.out.println("Book added successfully.");
        }
    }

    public Book linearSearchByTitle(String title){
        for(int i=0;i<count;i++){
            if(books[i].title.equalsIgnoreCase(title)){
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title){
        Arrays.sort(books, 0, count, Comparator.comparing(b->b.title.toLowerCase()));
        int low = 0;
        int high = count-1;
        while(low<=high){
            int mid = (high+low)/2;
            int result = books[mid].title.compareToIgnoreCase(title);

            if(result == 0)
                return books[mid];
            else if(result < 0)
                low = mid+1;
            else
                high = mid-1;
        }
        return null;
    }

    public void displayBooks(){
        for(int i=0;i<count;i++){
            System.out.println(books[i]);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(10);
        System.out.println();

        library.addBooks(new Book(101, "Wings of Fire", "A.P.J. Abdul Kalam"));
        library.addBooks(new Book(102, "Harry Potter", "J.K. Rowling"));
        library.addBooks(new Book(103, "Malgudi Days", "R.K. Narayan"));
        library.addBooks(new Book(104, "The Circle of Life", "Sudha Murty"));
        library.addBooks(new Book(105, "Angry River", "Ruskin Bond"));
        System.out.println();
        
        System.out.println("Books: ");
        library.displayBooks();
        System.out.println();
        
        System.out.println("Linear Search for 'Malgudi Days': ");
        Book b1 = library.linearSearchByTitle("Malgudi Days");
        System.out.println(b1!=null ? b1 : "Book not Found");
        System.out.println();
        
        System.out.println("Binary Search for 'Angry River': ");
        Book b2 = library.binarySearchByTitle("Angry River");
        System.out.println(b2!=null ? b2 : "Book not Found");
    }
}