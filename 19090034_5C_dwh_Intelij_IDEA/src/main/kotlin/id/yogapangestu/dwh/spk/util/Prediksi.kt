package id.yogapangestu.dwh.spk.util

import id.yogapangestu.dwh.spk.model.Resume
import id.yogapangestu.dwh.spk.repo.ResumeRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Prediksi {

    @Autowired
    lateinit var resumeRepo: ResumeRepo

    fun getLeastSquare(tglAwal: String, tglAkhir: String): Double {
        val awal = convertDate(tglAwal)
        val akhir = convertDate(tglAkhir)

        val data = resumeRepo.findByTglBetween(awal, akhir)

        val a = calculateA(data)
        val b = calculateB(data)
        val x = getFutureX(data.size)

        return a + (b * x)
    }

    fun getFutureX(i: Int): Int {
        var lx = generateX(i)[i-1]
        if(i % 2 == 0) { // jumlah data genap
            lx += 2
        } else { // jumlah data ganjil
            lx++
        }
        return lx
    }

    fun calculateB(data: List<Resume>): Double {
        val x = generateX(data.size)
        val x2 = calculateX2(x)
        val xy = calculateXY(x, data)
        return xy / x2
    }

    fun calculateXY(x: List<Int>, data: List<Resume>): Double {
        var i = 0
        var result = 0.0
        x.forEach {
            result += (it * data[i++].nilai)
        }
        return result
    }

    fun calculateX2(data: List<Int>): Double {
        var result = 0.0
        data.forEach {
            result += (it*it)
        }
        return result
    }

    /**
     * param i : jumlah cacah data
     */
    fun generateX(i: Int): List<Int> {
        var result = mutableListOf<Int>()
        if(i % 2 == 0) {
            var j = i - 1
            j -= (j*2)
            var n = 0
            for(n in 1..i) {
                result.add(j)
                j+=2
            }
        } else {
            var j = (i / 2).toInt() - i + 1
            var n = 0
            for(n in 1..i) {
                result.add(j)
                j++
            }
        }
        return result
    }

    fun calculateA(data: List<Resume>): Double {
        var nilai = 0.0;
        data.forEach {
            nilai += it.nilai
        }
        return nilai / data.size
    }

    fun convertDate(tgl: String): Int {
        val tanggal = tgl.substring(0,4) + tgl.substring(5,7) +
                tgl.substring(8,10)
        return Integer.parseInt(tanggal)
    }

}