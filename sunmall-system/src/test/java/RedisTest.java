import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by dongxu on 2018/11/20.
 */
public class RedisTest {

    private Jedis jedis;

    @Before
    public void before() {
        jedis = new Jedis("127.0.0.1", 6379);
    }

    @After
    public void after() {
        if (jedis != null) {
            jedis.close();
        }
    }

    @Test
    public void testString() {
        jedis.set("userName", "dongxiaoxu");
        System.out.println(jedis.get("userName"));
    }
}
