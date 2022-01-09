package id.yogapangestu.dwh.spk.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "dim_customer")
@Entity
class DimKantor {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Int? = null
}