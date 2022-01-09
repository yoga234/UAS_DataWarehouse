package id.yogapangestu.dwh.spk.repo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ResumeRepoTest {

    @Autowired
    lateinit var repo: ResumeRepo

    var logger = LoggerFactory.getLogger("ResumeRepoTest")

    @Test
    fun findByTglBetweenTest() {
        val result = repo.findByTglBetween(20050524, 20050615)
        logger.info("Jumlah data: " + result.size)
        Assertions.assertNotNull(result)
    }

}