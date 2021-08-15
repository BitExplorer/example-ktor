package example.repositories

import example.config.DatabaseFactory
import example.config.DatabaseFactory.dbQuery
import example.domain.Account
import example.domain.Description
import example.domain.DescriptionTable
import example.domain.Parameter
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jooq.generated.Tables

class ParameterRepository {
    suspend fun parameters(): List<Parameter> {
        return DatabaseFactory.doJooqQuery {
            it.selectFrom(Tables.T_PARM).fetchInto(Parameter::class.java)
        }
    }
}
