package id.yogapangestu.dwh.spk.repo

import id.yogapangestu.dwh.spk.model.Fakta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FaktaRepo: JpaRepository<Fakta, Int> {
}