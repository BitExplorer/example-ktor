package example.domain

import org.jetbrains.exposed.sql.Table

object DescriptionTable : Table("t_description") {
    val descriptionId = long("description_id").autoIncrement()
    val activeStatus = bool("active_status")
    val descriptionName = varchar("descriptionName", 4096)
}