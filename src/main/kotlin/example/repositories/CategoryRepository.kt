package example.repositories

import example.config.DatabaseFactory.dbQuery
import example.domain.Category
import example.domain.CategoryTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class CategoryRepository {


    suspend fun categories(): List<Category> = dbQuery {
        CategoryTable.selectAll().map { toCategory(it) }
    }

    private fun toCategory(row: ResultRow): Category =
        Category(
            categoryId = row[CategoryTable.categoryId],
            category = row[CategoryTable.category],
            activeStatus = row[CategoryTable.activeStatus]
        )

}


