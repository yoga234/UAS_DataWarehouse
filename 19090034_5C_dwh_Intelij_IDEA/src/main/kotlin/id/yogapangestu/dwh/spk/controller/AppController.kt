package id.yogapangestu.dwh.spk.controller

import id.yogapangestu.dwh.spk.model.Parameter
import id.yogapangestu.dwh.spk.util.Prediksi
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class AppController {

    var logger = LoggerFactory.getLogger("AppController")

    @Autowired
    lateinit var prediksi: Prediksi

    @RequestMapping("/")
    fun root(model: Model): String {
        model.addAttribute("param", Parameter())
        return "index"
    }

    @RequestMapping(value = [ "/proses" ], method = [ RequestMethod.POST ])
    fun proses(param: Parameter, model: Model): String {
//        logger.info("tgl awal: " + param.tglAwal)
        model.addAttribute("hasil",
            prediksi.getLeastSquare(param.tglAwal, param.tglAkhir))
        return "result"
    }

}