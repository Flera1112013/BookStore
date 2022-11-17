package in;

import model.Book;
import operation.Operation;
import org.junit.Test;

import static operation.Operation.initData;
import static org.junit.Assert.assertEquals;
import static valuesConstants.BookGenre.BELLETRE;

public class OperationTest {
    @Test
    public void getBookByIDTest() {
        initData();
        Book actualBook = Operation.getBookByID(2);
        assertEquals(new Book(2, "Граф Монте-Кристо", "А.Дюма", 1760.0, BELLETRE), actualBook);
    }
}
