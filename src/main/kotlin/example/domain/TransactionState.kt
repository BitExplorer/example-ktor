package example.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty

@JsonFormat
enum class TransactionState(val label: String) {
    @JsonProperty("cleared")
    cleared("cleared"),

    @JsonProperty("outstanding")
    outstanding("outstanding"),

    @JsonProperty("future")
    future("future"),

    @JsonProperty("undefined")
    undefined("undefined");

    fun value(): String = label
    override fun toString(): String = name.lowercase()

    companion object {
        private val VALUES = values()
        fun getByValue(label: String) = VALUES.firstOrNull { it.label == label }
    }
}