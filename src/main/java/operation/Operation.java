package operation;


import model.*;
import valuesConstants.BookGenre;

import java.util.ArrayList;


public class Operation {
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();

    public static void initData() {
        employees.add(new Employee(1, "Иванов Иван", 32));
        employees.add(new Employee(2, "Михайлов Федор", 24));
        employees.add(new Employee(3, "Иванов Алексей", 42));

        customers.add(new Customer(1, " Петров Петр", 16));
        customers.add(new Customer(2, " Измайлов Николай", 23));
        customers.add(new Customer(3, " Лиркин Семен", 56));

        books.add(new Book(1, "Война и мир", "Лев Толстой", 1600, BookGenre.BELLETRE));
        books.add(new Book(2, "Граф Монте-Кристо", "А.Дюма", 1760, BookGenre.BELLETRE));
        books.add(new Book(3, "Унесенные ветром", "М.Митчелл", 1900, BookGenre.BELLETRE));

        books.add(new Book(4, "Гарри Поттер и философский камень", "Дж.Роулинг", 800, BookGenre.PHANTASY));
        books.add(new Book(5, "Хроники Нарнии", "Кл.Льюис", 900, BookGenre.PHANTASY));
        books.add(new Book(6, "Сойка-пересмешница", "С.Коллинз", 1200, BookGenre.PHANTASY));
        books.add(new Book(7, "Гарри Поттер и узник Азкабана", "Дж.Роулинг", 880, BookGenre.PHANTASY));

        books.add(new Book(8, "Университет", "А.Азимов", 1300, BookGenre.SCIENCE_FICTION));
        books.add(new Book(9, "Пикник на обочине", "Стругацкий", 450, BookGenre.SCIENCE_FICTION));
        books.add(new Book(10, "Цветы для Элджернона", "Д.Киз", 780, BookGenre.SCIENCE_FICTION));

        books.add(new Book(11, "Топическая диагностика заболеваний НС", "Скоромец", 1500, BookGenre.SCIENCE));
        books.add(new Book(12, "Национальные рекомендации по неврологии", "Скворцова", 3500, BookGenre.SCIENCE));
        books.add(new Book(13, "Педиатрия", "Бутрий", 850, BookGenre.SCIENCE));
        books.add(new Book(14, "Как правильно кусать Цыпыча", "Данилова", 15000, BookGenre.SCIENCE));

        orders.add(new Order(1, 1, 2, new long[]{2, 7, 12, 14}));
        orders.add(new Order(2, 1, 1, new long[]{4, 6, 8, 14}));
        orders.add(new Order(3, 2, 3, new long[]{8, 2, 5, 7, 14}));
        orders.add(new Order(4, 3, 2, new long[]{1, 6, 3, 9, 14}));
    }

    public static Book getBookByID(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println(book);
               return book;

            }
        }
        return null;
    }

// кол-во проданных книг
    public static int getCountOfSoldBooks() {
        int count = 0;
        for (Order order : orders) {
            count += order.getBooks().length;
        }
        return count;
    }
// сумма проданных книг в одном заказе
    public static double getPriceOfSoldBooksInOrder(Order order) {
        double price = 0;
        for (long bookId : order.getBooks()) {
            Book book = getBookByID(bookId);
            if (book != null) {
                price += book.getPrice();
            }
        }
        return price;
    }
// сумма проданных книг всех
    public static double getAllPriceOfSoldBooks() {
        double price = 0;
        for (Order order : orders) {
            price +=getPriceOfSoldBooksInOrder(order);

        }
        return price;
    }

    public static Profit getProfitByEmployee(long employeeId ){
        int count=0;
        double price = 0;
        for (Order order:orders){
            if (order.getEmployeeId()==employeeId){
                price += getPriceOfSoldBooksInOrder(order);
                count+=order.getBooks().length;
            }
        }
        return new Profit(count, price);
    }
}
