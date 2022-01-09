package id.yogapangestu.dwh.spk.model

import java.math.BigDecimal
import javax.persistence.*

@Table(name = "fakta")
@Entity
open class Fakta {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "amount", precision = 131089)
    open var amount: BigDecimal? = null

    @ManyToOne
    @JoinColumn(name = "sk_waktu")
    open var skWaktu: DimWaktu? = null

    @Column(name = "sk_film")
    open var skFilm: Int? = null

    @Column(name = "sk_customer")
    open var skCustomer: Int? = null

    @Column(name = "sk_staf")
    open var skStaf: Int? = null
}