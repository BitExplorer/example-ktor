//package example.domain
//
//import org.jetbrains.exposed.sql.Table
//
//object CategoryTable : Table {
//
//        val id = varchar("id", 10) // Column<String>
//        val name = varchar("name", length = 50) // Column<String>
//        override val primaryKey = PrimaryKey(id, name = "PK_User_ID")
//}