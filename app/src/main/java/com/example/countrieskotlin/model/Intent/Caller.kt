package com.example.countrieskotlin.model.Intent

import kotlinx.serialization.Serializable

open class Caller {
    companion object {
        public const val INTENT_KEY = "CALLER_INTENT_KEY"
        public const val INTENT_DEFAULT = "INTENT_DEFAULT"

        fun mapCallerToDataObj (caller: CallerType): CallerData {
            return CallerData(caller::class.java.name)
        }

        fun mapDataObjToCaller (data: CallerData): CallerType {
            return when (data.callerName) {
                (JokeCard::class.java.name) -> JokeCard()
                (JokeMain::class.java.name) -> JokeMain()
                (JokeList::class.java.name) -> JokeList()
                else -> error("Missing Caller Type Specification for {${data.callerName}} in {${this::class.java.name}}.")
            }
        }
    }
}
