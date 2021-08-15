package example.domain

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.databind.ObjectMapper
import example.utils.*
import example.utils.Constants.ALPHA_NUMERIC_NO_SPACE_PATTERN
import example.utils.Constants.ALPHA_UNDERSCORE_PATTERN
import example.utils.Constants.ASCII_PATTERN
import example.utils.Constants.FIELD_MUST_BE_ALPHA_SEPARATED_BY_UNDERSCORE_MESSAGE
import example.utils.Constants.FIELD_MUST_BE_ASCII_MESSAGE
import example.utils.Constants.FIELD_MUST_BE_A_CURRENCY_MESSAGE
import example.utils.Constants.FIELD_MUST_BE_NUMERIC_NO_SPACE_MESSAGE
import example.utils.Constants.FIELD_MUST_BE_UUID_MESSAGE
import example.utils.Constants.UUID_PATTERN
import java.math.BigDecimal
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*


data class Transaction(
    @JsonProperty
    var transactionId: Long,

    @JsonProperty
    var guid: String,

    @JsonProperty
    var accountId: Long,

    @JsonProperty
    var accountType: AccountType?,

    @JsonProperty
    var accountNameOwner: String,

    @JsonProperty
    var transactionDate: Date,

    @JsonProperty
    var description: String,

    @JsonProperty
    var category: String,

    @JsonProperty
    var amount: BigDecimal,

    @JsonProperty
    var transactionState: TransactionState?,

    @JsonProperty
    var activeStatus: Boolean = true,

    @JsonProperty
    var reoccurringType: ReoccurringType? = ReoccurringType.Undefined,

    @JsonProperty
    var notes: String = ""
) {

    constructor() : this(
        0L, "", 0, AccountType.Undefined, "", Date(0),
        "", "", BigDecimal(0.00), TransactionState.Undefined, true, ReoccurringType.Undefined, ""
    )

    @JsonGetter("transactionDate")
    fun jsonGetterTransactionDate(): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        simpleDateFormat.isLenient = false
//        simpleDateFormat.timeZone = TimeZone.getDefault()
//        simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        return simpleDateFormat.format(this.transactionDate)
    }

//    @JsonGetter("dueDate")
//    fun jsonGetterDueDate(): String {
//        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
//        simpleDateFormat.isLenient = false
//        return simpleDateFormat.format(this.dueDate)
//    }

    @JsonSetter("transactionDate")
    fun jsonSetterTransactionDate(stringDate: String) {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        simpleDateFormat.isLenient = false
//        simpleDateFormat.timeZone = TimeZone.getDefault()
//        simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        this.transactionDate = Date(simpleDateFormat.parse(stringDate).time)
    }

//    @JsonSetter("dueDate")
//    fun jsonSetterDueDate(stringDate: String) {
//        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
//        simpleDateFormat.isLenient = false
//        this.dueDate = Date(simpleDateFormat.parse(stringDate).time)
//    }

    @JsonProperty
    var dueDate: Date? = null

    @JsonIgnore
    var receiptImageId: Long? = null

    @JsonIgnore
    var dateAdded: Timestamp = Timestamp(Calendar.getInstance().time.time)

    @JsonIgnore
    var dateUpdated: Timestamp = Timestamp(Calendar.getInstance().time.time)

    @JsonProperty
    var receiptImage: ReceiptImage? = null

    @JsonIgnore
    var account: Account? = null

    @JsonIgnore
    var categories = mutableListOf<Category>()

    override fun toString(): String {
        return mapper.writeValueAsString(this)
    }

    companion object {
        @JsonIgnore
        private val mapper = ObjectMapper()
    }
}
