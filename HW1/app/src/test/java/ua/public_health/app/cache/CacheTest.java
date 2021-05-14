package ua.public_health.app.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.public_health.app.model.Covid19_Information;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;



import static org.assertj.core.api.Assertions.assertThat;

public class CacheTest {
    private Logger logger = Logger.getLogger(CacheTest.class.getName());
    private Cache cache = new Cache();

    @BeforeEach
    public void setUp() {
        cache = new Cache();

        assertThat(cache.getMiss()).isEqualTo(0);
        assertThat(cache.getRequests()).isEqualTo(0);
        assertThat(cache.getHit()).isEqualTo(0);

        logger.log(Level.INFO, "CacheTest setUp.");
    }

    @Test
    public void requestNeverDoneBeforeTest_MissIncrements() {
        cache.cacheCall("aveiro");

        assertThat(cache.getMiss()).isEqualTo(1);
        assertThat(cache.getRequests()).isEqualTo(1);
        assertThat(cache.getHit()).isEqualTo(0);

        logger.log(Level.INFO, "CacheTest request never before called.");
    }

    @Test
    public void requestExpired_MissIncrements() throws InterruptedException {
        cache.cacheCall("aveiro");

        TimeUnit.MINUTES.sleep(2);

        cache.cacheCall("aveiro");

        assertThat(cache.getMiss()).isEqualTo(2);
        assertThat(cache.getRequests()).isEqualTo(2);
        assertThat(cache.getHit()).isEqualTo(0);

        logger.log(Level.INFO, "CacheTest request in cache expired.");
    }

    @Test
    public void requestAlreadyInCache_HitIncrements() throws InterruptedException {
        Covid19_Information response = cache.cacheCall("aveiro");

        TimeUnit.SECONDS.sleep(30);

        Covid19_Information response2 = cache.cacheCall("aveiro");

        assertThat(cache.getMiss()).isEqualTo(1);
        assertThat(cache.getRequests()).isEqualTo(2);
        assertThat(cache.getHit()).isEqualTo(1);

        assertThat(response).isEqualTo(response2);

        logger.log(Level.INFO, "CacheTest request is in cache, valid.");
    }

}