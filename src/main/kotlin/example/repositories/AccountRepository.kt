package example.repositories

import example.config.DatabaseFactory
import example.config.DatabaseFactory.dbQuery
import example.domain.Account
import example.domain.Description
import example.domain.DescriptionTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jooq.generated.Tables

class AccountRepository {
    suspend fun accounts(): List<Account> {
        return DatabaseFactory.doJooqQuery {
            it.selectFrom(Tables.T_ACCOUNT).fetchInto(Account::class.java)
        }
    }
}
