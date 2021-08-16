package example.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty

@JsonFormat
enum class ReoccurringType(val label: String) {
    @JsonProperty("monthly")
    monthly("monthly"),

    @JsonProperty("annually")
    annually("annually"),

    @JsonProperty("bi_annually")
    bi_annually("bi_annually"),

    @JsonProperty("fortnightly")
    fortnightly("fortnightly"),

    @JsonProperty("quarterly")
    quarterly("quarterly"),

    @JsonProperty("onetime")
    onetime("onetime"),

    @JsonProperty("undefined")
    undefined("undefined");

    fun value(): String = label
    override fun toString(): String = name.lowercase()


}