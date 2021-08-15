package example.repositories

import example.config.DatabaseFactory
import example.config.DatabaseFactory.dbQuery
import example.domain.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jooq.generated.Tables

class TransactionRepository {
    suspend fun transactions(): List<Transaction> {
        return DatabaseFactory.doJooqQuery {
            it.selectFrom(Tables.T_TRANSACTION).fetchInto(Transaction::class.java)
                //.map(rec -> AccountType.valueOf(rec.getValue(T_TRANSACTION.)))
        }
    }
}
