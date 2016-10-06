package club.data;

import java.io.*;
import java.util.*;

import club.business.*;

public class BookIO
{
    private static ArrayList<Book> books = null;
    
    public static ArrayList<Book> getBooks(String path)
    {
        books = new ArrayList<Book>();
        File file = new File(path);
        try
        {
            BufferedReader in = 
                new BufferedReader(
                new FileReader(file));

            String line = in.readLine();
            while (line != null)
            {
                StringTokenizer t = new StringTokenizer(line, "|");
                if (t.countTokens() >= 3)
                {
                    String code = t.nextToken();
                    String description = t.nextToken();
                    String qtyAsString = t.nextToken();
                    int qty = Integer.parseInt(qtyAsString);

                    Book book = new Book();
                    book.setCode(code);
                    book.setDescription(description);
                    book.setQuantity(qty);

                    books.add(book);
                }
                line = in.readLine();
            }
            in.close();
            return books;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static Book getBook(String code, String path)
    {
        books = getBooks(path);
        for (Book book : books)
        {            
            if (code != null &&
                code.equalsIgnoreCase(book.getCode()))
            {
                return book;
            }
        }        
        return null;
    }

    public static boolean exists(String code, String path)
    {
        books = getBooks(path);
        for (Book book : books)
        {            
            if (code != null &&
                code.equalsIgnoreCase(book.getCode()))
            {
                return true;
            }
        }        
        return false;
    }

    private static void saveBooks(ArrayList<Book> books,
            String path)
    {
        try
        {
            File file = new File(path);
            PrintWriter out = 
                new PrintWriter(
                new FileWriter(file));

            for (Book book : books)
            {                        
                out.println(book.getCode() + "|"
                        + book.getDescription() + "|"
                        + book.getQuantity());
            }

            out.close();        
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void insert(Book product, String path)
    {
        books = getBooks(path);
        books.add(product);
        saveBooks(books, path);
    }

    public static void update(Book book, String path)
    {
        books = getBooks(path);
        for (int i = 0; i < books.size(); i++)
        {
            Book b = books.get(i);
            if (book.getCode() != null &&
                book.getCode().equalsIgnoreCase(b.getCode()))
            {
                books.set(i, book);
            }
        }
        saveBooks(books, path);
    }

    public static void delete(Book book, String path)
    {
        books = getBooks(path);
        for (int i = 0; i < books.size(); i++)
        {
            Book b = books.get(i);
            if (book != null &&
                book.getCode().equalsIgnoreCase(b.getCode()))
            {
                books.remove(i);
            }
        }
        saveBooks(books, path);
    }
}