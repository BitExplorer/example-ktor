package example.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import example.utils.Constants
import example.utils.Constants.FIELD_MUST_BE_A_CURRENCY_MESSAGE
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class ValidationAmount(
    @JsonProperty
    var validationId: Long,

    @JsonProperty
    var accountId: Long,

    @JsonProperty
    var validationDate: Timestamp,

    @JsonProperty
    var activeStatus: Boolean = true,

    @JsonProperty
    var transactionState: TransactionState,

    @JsonProperty
    var amount: BigDecimal
) {
    constructor() : this(0L, 0L, Timestamp(0L), true, TransactionState.Undefined, BigDecimal(0.0))

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
