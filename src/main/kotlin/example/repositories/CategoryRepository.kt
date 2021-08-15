package example.repositories

import example.config.DatabaseFactory
import example.config.DatabaseFactory.dbQuery
import example.config.DatabaseFactory.doJooqQuery
import example.domain.Category
import example.domain.CategoryTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import org.jooq.generated.Tables.T_CATEGORY
import org.jooq.generated.tables.TCategory

//class CategoryRepository(val databaseFactory: DatabaseFactory) {
class CategoryRepository() {

//    suspend fun getCategories(): List<Category> {
//        return databaseFactory.doJooqQuery {
//            it.selectFrom(TCategory).fetchInto(Category::class.java)
//        }
//    }

    suspend fun categories(): List<Category> {
        return doJooqQuery {
            it.selectFrom(T_CATEGORY).fetchInto(Category::class.java)
        }
    }

    suspend fun getCategories(): List<Category> = dbQuery {
        CategoryTable.selectAll().map { toCategory(it) }
    }

    private fun toCategory(row: ResultRow): Category =
        Category(
            categoryId = row[CategoryTable.categoryId],
            category = row[CategoryTable.category],
            activeStatus = row[CategoryTable.activeStatus]
        )

}


