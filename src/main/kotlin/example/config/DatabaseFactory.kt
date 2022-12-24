package example.config

import org.jetbrains.exposed.sql.Database
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.transactions.transaction
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL

object DatabaseFactory {

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        //config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = "jdbc:postgresql://192.168.10.25:5432/finance_db"
        config.username = "henninb"
        config.password = "monday1"
        config.maximumPoolSize = 3
//        config.isAutoCommit = false
//        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
//        config.validate()
        return HikariDataSource(config)
    }

    fun init() {
        Database.connect(hikari())
    }

    suspend fun <T> doJooqQuery(block: (DSLContext) -> T): T = withContext(Dispatchers.IO) {
        transaction {block(DSL.using(hikari(), SQLDialect.POSTGRES))}
    }

    suspend fun <T> dbQuery(
        block: () -> T): T = withContext(Dispatchers.IO) {
            transaction { block() }
        }
}