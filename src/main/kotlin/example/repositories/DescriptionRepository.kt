package example.repositories

import example.config.DatabaseFactory.dbQuery
import example.domain.Description
import example.domain.DescriptionTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class DescriptionRepository {
    suspend fun descriptions(): List<Description> = dbQuery {
        DescriptionTable.selectAll().map { toDescription(it) }
    }

    private fun toDescription(row: ResultRow): Description =
        Description(
            descriptionId = row[DescriptionTable.descriptionId],
            description = row[DescriptionTable.description],
            activeStatus = row[DescriptionTable.activeStatus]
        )

}


