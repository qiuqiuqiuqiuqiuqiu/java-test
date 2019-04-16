import com.test.design.SimpleConnPool;
import org.junit.Test;
import java.sql.Connection;
import java.util.HashMap;

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
}
