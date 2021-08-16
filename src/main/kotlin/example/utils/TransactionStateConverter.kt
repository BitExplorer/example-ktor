package example.utils

import example.domain.AccountType
import example.domain.TransactionState
import org.jooq.impl.EnumConverter

class TransactionStateConverter : EnumConverter<String, TransactionState>(String::class.java, TransactionState::class.java)
