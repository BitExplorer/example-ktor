package example.repositories

import example.config.DatabaseFactory
import example.config.DatabaseFactory.dbQuery
import example.domain.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jooq.generated.Tables

class ReceiptImageRepository {
    suspend fun receiptImages(): List<ReceiptImage> {
        return DatabaseFactory.doJooqQuery {
            it.selectFrom(Tables.T_RECEIPT_IMAGE).fetchInto(ReceiptImage::class.java)
        }
    }
}
