import com.test.design.SimpleConnPool;
import org.junit.Test;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class test {
    @Test
    public void testGetConnection(){
        Connection conn = SimpleConnPool.getConnection();
    }

    @Test
    public void testCloseConnection(){
        Connection conn = SimpleConnPool.getConnection();
        SimpleConnPool.closeConnection(conn);
    }


    LinkedList ll = new LinkedList();

    Iterator it = ll.iterator();
}
