package example.domain

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.databind.ObjectMapper
import java.math.BigDecimal
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
data class Payment(
    @JsonProperty

    var paymentId: Long,

    @JsonProperty
    var accountNameOwner: String,

    @JsonProperty
    var transactionDate: Date,

    @JsonProperty
    var amount: BigDecimal,

    @JsonProperty
    var guidSource: String?,

    @JsonProperty
    var guidDestination: String?,

    @JsonProperty
    var activeStatus: Boolean = true
) {

    constructor() : this(0L, "", Date(0), BigDecimal(0.00), "", "")

    @JsonGetter("transactionDate")
    fun jsonGetterPaymentDate(): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        simpleDateFormat.isLenient = false
        return simpleDateFormat.format(this.transactionDate)
    }

    @JsonSetter("transactionDate")
    fun jsonSetterPaymentDate(stringDate: String) {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        simpleDateFormat.isLenient = false
        this.transactionDate = Date(simpleDateFormat.parse(stringDate).time)
    }

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
