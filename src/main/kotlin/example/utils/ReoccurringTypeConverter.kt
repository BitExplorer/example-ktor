package example.utils

import example.domain.AccountType
import example.domain.ReoccurringType
import org.jooq.impl.EnumConverter

class ReoccurringTypeConverter : EnumConverter<String, ReoccurringType>(String::class.java, ReoccurringType::class.java)