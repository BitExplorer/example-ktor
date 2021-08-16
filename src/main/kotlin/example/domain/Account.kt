package example.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Account(
    @JsonProperty
    var accountId: Long,

    @JsonProperty
    var accountNameOwner: String,

    @JsonProperty
    var accountType: AccountType,

    @JsonProperty
    var activeStatus: Boolean = true,

    @JsonProperty
    var moniker: String,

    @JsonProperty
    var outstanding: BigDecimal,

    @JsonProperty
    var future: BigDecimal,

    @JsonProperty
    var cleared: BigDecimal,

    @JsonProperty
    var dateClosed: Timestamp
) {

    constructor() : this(
        0L, "", AccountType.undefined, true,
        "0000", BigDecimal(0.0), BigDecimal(0.0), BigDecimal(0.0), Timestamp(0)
    )

    @JsonIgnore
    var dateAdded: Timestamp = Timestamp(Calendar.getInstance().time.time)

    @JsonIgnore
    var dateUpdated: Timestamp = Timestamp(Calendar.getInstance().time.time)

    override fun toString(): String {
        //mapper.setTimeZone(TimeZone.getDefault())
        return mapper.writeValueAsString(this)
    }

    companion object {
        @JsonIgnore
        private val mapper = ObjectMapper()
    }
}