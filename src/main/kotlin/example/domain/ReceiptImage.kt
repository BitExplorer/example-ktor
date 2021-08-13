package example.domain

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import java.sql.Timestamp
import java.util.*



@JsonIgnoreProperties(ignoreUnknown = true)
data class ReceiptImage(
    @JsonProperty
    var receiptImageId: Long,

    @JsonProperty
    var transactionId: Long,

    @JsonProperty
    var activeStatus: Boolean = true
) {

    constructor() : this(0L, 0L, true)

    @JsonIgnore
    var dateAdded: Timestamp = Timestamp(Calendar.getInstance().time.time)

    @JsonIgnore
    var dateUpdated: Timestamp = Timestamp(Calendar.getInstance().time.time)

    @JsonGetter("image")
    fun jsonGetterJpgImage(): String {
        //https://cryptii.com/pipes/base64-to-hex
        //logger.info(this.image.toHexString())

        return Base64.getEncoder().encodeToString(this.image)
    }

    //TODO: 2021-01-09, temporary method
    private fun ByteArray.toHexString(): String {
        return this.joinToString("") {
            String.format("%02x", it)
        }
    }

    @JsonProperty
    var imageFormatType: ImageFormatType = ImageFormatType.Undefined

    @JsonProperty
    lateinit var image: ByteArray

    @JsonProperty
    lateinit var thumbnail: ByteArray

    override fun toString(): String {
        return mapper.writeValueAsString(this)
    }

    companion object {
        @JsonIgnore
        private val mapper = ObjectMapper()
    }
}