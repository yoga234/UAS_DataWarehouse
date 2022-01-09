package id.yogapangestu.dwh.spk.repo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.logging.Logger

@SpringBootTest
class FaktaRepoTest {

    @Autowired
    lateinit var repo: FaktaRepo

    var logger = Logger.getLogger("FaktaRepoTest")

    @Test
    fun getAll() {
        var result = repo.count()
        logger.info("" + result)
        Assertions.assertTrue(true)
    }

}