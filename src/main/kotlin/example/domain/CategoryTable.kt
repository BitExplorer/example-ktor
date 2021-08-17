package example.domain

import org.jetbrains.exposed.sql.Table

object CategoryTable : Table("t_category") {
    val categoryId = long("category_id").autoIncrement()
    val activeStatus = bool("active_status")
    val categoryName = varchar("categoryName", 4096)
}