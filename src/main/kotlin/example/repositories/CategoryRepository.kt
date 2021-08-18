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
import java.sql.Date
import java.time.LocalDateTime

//class CategoryRepository(val databaseFactory: DatabaseFactory) {
class CategoryRepository() {
    suspend fun categories(): List<Category> {
        return doJooqQuery {
            it.selectFrom(T_CATEGORY).fetchInto(Category::class.java)
        }
    }


    suspend fun insertCategory(category: Category) {
        return doJooqQuery {
            it.insertInto(T_CATEGORY).columns(T_CATEGORY.CATEGORY_NAME, T_CATEGORY.ACTIVE_STATUS, T_CATEGORY.DATE_ADDED, T_CATEGORY.DATE_UPDATED)
                .values("testing1234", false, LocalDateTime.now(), LocalDateTime.now()).returning(T_CATEGORY.CATEGORY_ID).fetchOne()
            it.newRecord(T_CATEGORY, category).store()
//.fields

        }
    }


//    DSL.using(configuration)
//    .insertInto(TABLENAME, ...)
//    .values(...)
//    .returning(TABLENAME.ID)
//    .fetchOne();

//    dslContext.newRecord(TABLE, POJO);
//    record.insert();
//    POJO.setId(record.getId());

//    suspend fun getCategories(): List<Category> = dbQuery {
//        CategoryTable.selectAll().map { toCategory(it) }
//    }
//
//    private fun toCategory(row: ResultRow): Category =
//        Category(
//            categoryId = row[CategoryTable.categoryId],
//            category = row[CategoryTable.category],
//            activeStatus = row[CategoryTable.activeStatus]
//        )

}


