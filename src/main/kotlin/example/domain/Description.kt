package example.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Table
import java.sql.Timestamp
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
data class Description(
    @JsonProperty
    var descriptionId: Long,

    @JsonProperty
    var activeStatus: Boolean = true,

    @JsonProperty
    var description: String
) {
    constructor() : this(0L, true, "")

    @JsonIgnore
    var dateAdded: Timestamp = Timestamp(Calendar.getInstance().time.time)

    @JsonIgnore
    var dateUpdated: Timestamp = Timestamp(Calendar.getInstance().time.time)

    override fun toString(): String {
        return mapper.writeValueAsString(this)
    }

    companion object {
        @JsonIgnore
        private val mapper = ObjectMapper()
    }
}
