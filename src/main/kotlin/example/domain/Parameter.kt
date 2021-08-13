package example.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import java.sql.Timestamp
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Parameter(
    @JsonProperty
    var parameterId: Long,

    @JsonProperty
    var parameterName: String,

    @JsonProperty
    var parameterValue: String,

    @JsonProperty
    var activeStatus: Boolean = true
) {
    constructor() : this(0L, "", "", true)

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
