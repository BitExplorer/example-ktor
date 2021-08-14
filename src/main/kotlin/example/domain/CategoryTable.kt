package example.domain

import org.jetbrains.exposed.sql.Table

object CategoryTable : Table() {
    val categoryId = long("category_id").autoIncrement().primaryKey()
    val activeStatus = bool("activeStatus")
    val category = varchar("category", 4096)
}