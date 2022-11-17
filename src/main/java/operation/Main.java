package operation;

import static operation.Operation.*;


public class Main {

    public static void main(String[] args) {
        initData();
        String bookInfo = String.format("Общее количество проданных книг %d на сумму %f", getCountOfSoldBooks(),
                getAllPriceOfSoldBooks());

        System.out.println(bookInfo);
    }
}
