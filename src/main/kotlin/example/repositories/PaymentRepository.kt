package example.repositories

import example.config.DatabaseFactory
import example.config.DatabaseFactory.dbQuery
import example.domain.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jooq.generated.Tables

class PaymentRepository {
    suspend fun payments(): List<Payment> {
        return DatabaseFactory.doJooqQuery {
            it.selectFrom(Tables.T_PAYMENT).fetchInto(Payment::class.java)
        }
    }
}
