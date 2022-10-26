import java.util.Arrays;
import java.util.Scanner;
//###########Part 1
class ID
{
    int age;
    String name;
    public ID (int age,String name)
    {
        this.age = age;
        this.name = name;
    }
}
//####Part 2
class books
{
    int print_date;
    String book_name;
    String author;
    public books (int print_date,String book_name,String author)//constructor
    {
        this.print_date = print_date;
        this.book_name = book_name;
        this.author = author;
    }
    public void print_all()//function that writes all the information about the book
    {
        System.out.println("\nThe title of the book is " + this.book_name + "\nThe author of this book is " + this.author+ "\nThe date of writing this book is " +
                this.print_date);
    }
}

class library
{

    private int count = 1;
    private books library_storage[] = new books[count];
    private int counter = 0;

    public void newObj(books book)
    {
        this.library_storage[counter] = book;
        this.library_storage = Arrays.copyOf(library_storage,this.count+1);
        count++;
        counter++;
    }

    public void printOne(int i)
    {
        this.library_storage[i].print_all();
    }

    public void print()
    {
        if (library_storage.length == 1)
        {
            System.out.println("Error! Not enough items!");
            return;
        }
        for (int i = 0; i < this.library_storage.length-1; i++)
        {
            this.library_storage[i].print_all();
        }
    }
    public void sortBydate()
    {
        int n = this.library_storage.length;
        books temp;
        if (library_storage.length <= 2)
        {
            System.out.println("Error! Not enough items!");
            return;
        }
        for(int i=0; i < n-1; i++){
            for(int j=1; j < (n-i-1); j++)
            {
                if(this.library_storage[j-1].print_date > this.library_storage[j].print_date)
                {
                    temp = this.library_storage[j-1];
                    this.library_storage[j-1] = this.library_storage[j];
                    this.library_storage[j] = temp;
                }

            }
        }
    }
    public void findBYname(String name)
    {
        if (library_storage.length == 1)
        {
            System.out.println("Error! Not enough items!");
            return;
        }
        for (int i = 0; i < this.library_storage.length-1; i++)
        {
            if (this.library_storage[i].book_name.equals(name))
            {
                this.library_storage[i].print_all();
                return;
            }
        }
        System.out.println("Error!!");
    }
    public void findBYdate(int date)
    {
        if (library_storage.length == 1)
        {
            System.out.println("Error! Not enough items!");
            return;
        }
        for (int i = 0; i < this.library_storage.length-1; i++)
        {
            if (this.library_storage[i].print_date == date)
            {
                this.library_storage[i].print_all();
                return;
            }
        }
        System.out.println("Error!!");

    }
}

public class Main
{
    public static void changeID(ID id)//for part 1.2
    {
        id.age = 100;
        id.name = "Petya";
    }
    public static void print_menu()//for user dialog
    {
        System.out.println("Welcome to the library!\n" +
                "Choose an option to proceed:\n" +
                "1 - add books to collection\n" +
                "2 - print all books\n" +
                "3 - sort books by year\n" +
                "4 - search books by title\n" +
                "5 - search books by year\n" +
                "0 - exit the program");
    }
    public static void addOb(library Library)//for adding odject to collection class
    {
        int year;
        String bookname,name;
        Scanner scan = new Scanner(System.in);
        System.out.println("print year of writing the book");
        year = scan.nextInt();
        System.out.println("print the title of the book");
        bookname = scan.nextLine();
        bookname = scan.nextLine();
        System.out.println("print the name of the author");
        name = scan.nextLine();
        books tr = new books(year,bookname,name);
        Library.newObj(tr);
    }
    public static void main(String[] args)
    {
        System.out.println(1000);
        ID passport = new ID(5,"Vasya");
        ID visa = passport;
        passport.age = 10;
        System.out.println(visa.age);
        changeID(passport);
        System.out.println("\n new name = " + passport.name + "\n new age = " + passport.age);
        // #################Part2


        Scanner scan = new Scanner(System.in);
        boolean menu = true;
        int year;
        String title;
        library Library = new library();
        while (menu)
        {
            print_menu();
            int question = scan.nextInt();
            switch (question)
            {
                case 1:
                    addOb(Library);
                    break;
                case 2:
                    Library.print();
                    break;
                case 3:
                    Library.sortBydate();
                    break;
                case 4:
                    System.out.println("print book's title");
                    title = scan.nextLine();
                    title = scan.nextLine();
                    Library.findBYname(title);
                    break;
                case 5:
                    System.out.println("print year of writing the book");
                    year= scan.nextInt();
                    Library.findBYdate(year);
                    break;
                case 0:
                    menu = false;

            }

        }

    }



}