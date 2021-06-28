import com.feng.pojo.Book;
import com.feng.service.impl.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookServiceImpl bookServiceImpl = context.getBean("bookServiceImpl", BookServiceImpl.class);

        for (Book book : bookServiceImpl.queryAllBook()) {
            System.out.println(book);
        }


    }
}
