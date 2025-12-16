package src.main.java.system.bookstore;

import src.main.java.system.bookstore.MyComparable;

public class Book implements MyComparable<Book> {
    // 1. Fields (Encapsulation - Tính đóng gói)
    private String id;
    private String title;
    private String author;
    private double price;
    private int pages;

    // 2. Constructor
    public Book(String id, String title, String author, double price, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }

    // 3. Getters và Setters (Encapsulation)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    // 4. Implement MyComparable interface (Implement abstraction)
    @Override
    public int compareTo(Book otherBook) {
        // So sánh theo title (A-Z)
        return this.title.compareTo(otherBook.title);
    }

    // 5. Additional comparison methods
    public int compareByPrice(Book other) {
        // So sánh theo giá
        return Double.compare(this.price, other.price);
    }

    public int compareByPages(Book other) {
        // So sánh theo số trang
        return Integer.compare(this.pages, other.pages);
    }

    public int compareByAuthor(Book other) {
        // So sánh theo tên tác giả
        return this.author.compareTo(other.author);
    }

    // 6. toString method
    @Override
    public String toString() {
        return String.format("Book[ID=%s, Title='%s', Author='%s', Price=%.2f, Pages=%d]",
                id, title, author, price, pages);
    }

    // 7. equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return id.equals(book.id);
    }

    // 8. hashCode method
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}