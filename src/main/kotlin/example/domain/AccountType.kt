package example.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty

@JsonFormat
enum class AccountType(val label: String) {
    @JsonProperty("credit")
    credit("credit"),

    @JsonProperty("debit")
    debit("debit"),

    @JsonProperty("undefined")
    undefined("undefined");

    override fun toString(): String = name.lowercase()


    companion object
}