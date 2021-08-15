//package example.repositories
//
//import example.config.DatabaseFactory
//import example.config.DatabaseFactory.dbQuery
//import example.domain.*
//import org.jetbrains.exposed.sql.ResultRow
//import org.jetbrains.exposed.sql.selectAll
//import org.jooq.generated.Tables
//
//class UserRepository {
//    suspend fun users(): List<User> {
//        return DatabaseFactory.doJooqQuery {
//            it.selectFrom(Tables.T_USER).fetchInto(User::class.java)
//        }
//    }
//}
