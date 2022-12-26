package tn.mbach.warnMe.Data

import java.util.regex.Pattern

//
const val PREF_NAME = "PREF_warnMe"
const val ID = "ID"
const val NAME = "NAME"
const val EMAIL = "EMAIL"
const val BIO = "BIO"
const val AVATAR = "AVATAR"
const val TOKEN = "TOKEN"
const val RememberEmail="RememberEmail"
const val RememberPassword="RememberPassword"
const val ROLE="ROLE"
//
val emailRegex = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )



