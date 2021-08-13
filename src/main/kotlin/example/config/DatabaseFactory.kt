package example.config

import org.jetbrains.exposed.sql.Database
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

object DatabaseFactory {

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        //config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = "jdbc:postgresql://192.168.100.124:5432/finance_db"
        config.username = "henninb"
        config.password = "monday1"
//        config.maximumPoolSize = 3
//        config.isAutoCommit = false
//        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
//        config.validate()
        return HikariDataSource(config)
    }

    fun init() {
        Database.connect(hikari())
    }
}