// Abstract class representing library items
abstract class LibraryItem {
    private String title;
    private String author;
    private int itemId;

    // Constructors
    public LibraryItem(String title, String author, int itemId) {
        this.title = title;
        this.author = author;
        this.itemId = itemId;
    }

    public LibraryItem(String title) {
        this(title, "Unknown", 0);
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayDetails();

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getItemId() {
        return itemId;
    }
}

// Book class inherits from LibraryItem and implements Lendable
class Book extends LibraryItem implements Lendable {
    private int pages;

    // Constructors
    public Book(String title, String author, int itemId, int pages) {
        super(title, author, itemId);
        this.pages = pages;
    }

    public Book(String title, int pages) {
        super(title);
        this.pages = pages;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book Title: " + getTitle() + ", Author: " + getAuthor() + ", Pages: " + pages);
    }

    @Override
    public void lend() {
        System.out.println("The book is now lent out.");
    }

    // Overloaded method
    public void lend(String memberName) {
        System.out.println("The book is lent out to " + memberName + ".");
    }
}

// Magazine class inherits from LibraryItem
class Magazine extends LibraryItem {
    private String genre;

    // Constructors
    public Magazine(String title, String author, int itemId, String genre) {
        super(title, author, itemId);
        this.genre = genre;
    }

    public Magazine(String title, String genre) {
        super(title);
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        System.out.println("Magazine Title: " + getTitle() + ", Genre: " + genre);
    }
}

// Abstract class for Member
abstract class Member {
    private String name;
    private int memberId;

    // Constructors
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public Member(String name) {
        this(name, 0);
    }

    // Abstract method to be implemented by subclasses
    public abstract void borrowItem();

    // Getters
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void displayMemberInfo() {
        System.out.println("Member Name: " + name + ", Member ID: " + memberId);
    }
}

// StudentMember class inherits from Member and implements Payable
class StudentMember extends Member implements Payable {
    private String course;

    // Constructors
    public StudentMember(String name, int memberId, String course) {
        super(name, memberId);
        this.course = course;
    }

    public StudentMember(String name, String course) {
        super(name);
        this.course = course;
    }

    @Override
    public void borrowItem() {
        System.out.println("Student " + getName() + " borrowed an item.");
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Student " + getName() + " made a payment of $" + amount);
    }

    // Method to display course
    public void displayStudentDetails() {
        System.out.println("Student " + getName() + " is enrolled in " + course + " course.");
    }
}

// StaffMember class inherits from Member and implements Payable
class StaffMember extends Member implements Payable {
    private String department;

    // Constructors
    public StaffMember(String name, int memberId, String department) {
        super(name, memberId);
        this.department = department;
    }

    public StaffMember(String name, String department) {
        super(name);
        this.department = department;
    }

    @Override
    public void borrowItem() {
        System.out.println("Staff member " + getName() + " borrowed an item.");
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Staff member " + getName() + " made a payment of $" + amount);
    }

    // Method to display department
    public void displayStaffDetails() {
        System.out.println("Staff member " + getName() + " works in the " + department + " department.");
    }
}

// Interface representing items that can be lent
interface Lendable {
    void lend();
}

// Interface representing items that are payable
interface Payable {
    void makePayment(double amount);
}

// Invoice class for handling invoices
class Invoice {
    private int invoiceId;
    private double amount;

    // Constructors
    public Invoice(int invoiceId, double amount) {
        this.invoiceId = invoiceId;
        this.amount = amount;
    }

    public Invoice(double amount) {
        this(0, amount);
    }

    public void printInvoice() {
        System.out.println("Invoice ID: " + invoiceId + ", Amount: $" + amount);
    }
}

// Payment class for handling payments
class Payment {
    private double amount;

    // Constructors
    public Payment(double amount) {
        this.amount = amount;
    }

    public Payment() {
        this(0.0);
    }

    public void makePayment() {
        System.out.println("Payment of $" + amount + " has been processed.");
    }
}

// Main class to demonstrate the system
public class LibrarySystem {
    public static void main(String[] args) {
        // Create a book and a magazine
        Book book = new Book("Java Programming", "John Doe", 1, 300);
        Magazine magazine = new Magazine("Tech Today", "Jane Doe", 2, "Technology");

        // Create members
        StudentMember student = new StudentMember("Alice", 101, "Computer Science");
        StaffMember staff = new StaffMember("Bob", 102, "HR");

        // Display details
        book.displayDetails();
        magazine.displayDetails();

        // Borrow items
        student.borrowItem();
        staff.borrowItem();

        // Make payments
        student.makePayment(50.0);
        staff.makePayment(75.0);

        // Display specific details for Student and Staff
        student.displayStudentDetails();  // Display student's course
        staff.displayStaffDetails();      // Display staff's department

        // Create an invoice and payment
        Invoice invoice = new Invoice(1, 100.0);
        Payment payment = new Payment(100.0);

        invoice.printInvoice();
        payment.makePayment();
    }
}
