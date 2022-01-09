package id.yogapangestu.dwh.spk.util

import id.yogapangestu.dwh.spk.repo.ResumeRepo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PrediksiTest {

    @Autowired
    lateinit var prediksi: Prediksi

    @Autowired
    lateinit var resumeRepo: ResumeRepo

    var log = LoggerFactory.getLogger("PrediksiTest")

    @Test
    fun getFutureXTest() {
        val resultOdd = prediksi.getFutureX(7)
        Assertions.assertEquals(4, resultOdd)
        val resultEven = prediksi.getFutureX(6)
        Assertions.assertEquals(7, resultEven)
    }

    @Test
    fun calculateXYTest() {
        val x = prediksi.generateX(7)
        val data = resumeRepo.findByTglBetween(20050524, 20050530)
        val result = prediksi.calculateXY(x, data)
        log.info("Hasilnya : " + result.toString())
        Assertions.assertNotNull(result)
    }

    @Test
    fun convertDateTest() {
        val result =  prediksi.convertDate("2005-06-20")
        Assertions.assertEquals(20050620, result)
    }

    @Test
    fun calculateATest() {
        val data = resumeRepo.findByTglBetween(20050524, 20050530)
        val result = prediksi.calculateA(data)
        log.info("Hasilnya: " + result.toString())
        Assertions.assertNotNull(result)
    }

    @Test
    fun generateXTest() {
        val result = prediksi.generateX(7)
        log.info("Hasil ganjil: " + result.toString())
        Assertions.assertNotNull(result)
        val resultEven = prediksi.generateX(6)
        log.info("Hasil genap: " + resultEven.toString())
        Assertions.assertNotNull(result)
    }

    @Test
    fun calculcateX2Test() {
        val data = prediksi.generateX(7)
        val result = prediksi.calculateX2(data)
        Assertions.assertEquals(28.0, result)
    }

}