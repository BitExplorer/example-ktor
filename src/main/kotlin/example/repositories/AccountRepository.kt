package example.repositories

import example.config.DatabaseFactory
import example.config.DatabaseFactory.dbQuery
import example.domain.Account
import example.domain.Category
import example.domain.Description
import example.domain.DescriptionTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jooq.generated.Tables
import java.time.LocalDateTime

class AccountRepository {
    suspend fun accounts(): List<Account> {
        return DatabaseFactory.doJooqQuery {
            it.selectFrom(Tables.T_ACCOUNT).fetchInto(Account::class.java)
        }
    }

    suspend fun insertAccount(account: Account) {
        return DatabaseFactory.doJooqQuery {
            it.insertInto(Tables.T_ACCOUNT).columns(
                Tables.T_ACCOUNT.ACCOUNT_NAME_OWNER,
                Tables.T_ACCOUNT.ACCOUNT_TYPE,
                Tables.T_ACCOUNT.MONIKER,
                Tables.T_ACCOUNT.ACTIVE_STATUS,
                Tables.T_ACCOUNT.DATE_ADDED,
                Tables.T_ACCOUNT.DATE_UPDATED
            )
                .values(account.accountNameOwner, account.accountType, account.moniker, account.activeStatus, LocalDateTime.now(), LocalDateTime.now())
                .returning(Tables.T_ACCOUNT.ACCOUNT_ID).fetchOne()
            //it.newRecord(T_ACCOUNT, account).store()

        }
    }
}
