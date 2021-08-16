package example.utils

import example.domain.AccountType
import org.jooq.impl.EnumConverter

class AccountTypeConverter : EnumConverter<String, AccountType>(String::class.java, AccountType::class.java)
