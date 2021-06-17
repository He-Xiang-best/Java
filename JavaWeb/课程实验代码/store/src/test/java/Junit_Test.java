/*
 * @ClassName Test
 * @description: TODO
 * @author: 何翔
 * @Date 2021/4/30 10:50
 */

import dao.BookDao;
import dao.impl.BookDaoImpl;
import model.Book;
import org.junit.Test;

import java.util.List;

public class Junit_Test {

    @Test
    public void test_queryBooks(){
        BookDao bookDao = new BookDaoImpl();
        List<Book> bookList = bookDao.queryBooks();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
