package com.example.countrieskotlin.model

import com.squareup.moshi.JsonClass
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class IntentInfo (
    val passingClassName: String,
    val categories: String?
)

object IntentInfoSerializer : KSerializer<IntentInfo> {
    override val descriptor: SerialDescriptor = IntentInfo.serializer().descriptor

    override fun serialize(encoder: Encoder, value: IntentInfo) {
//        val surrogate = ColorSurrogate((value.rgb shr 16) and 0xff, (value.rgb shr 8) and 0xff, value.rgb and 0xff)
//        encoder.encodeSerializableValue(ColorSurrogate.serializer(), surrogate)
    }

    override fun deserialize(decoder: Decoder): IntentInfo {
        val surrogate = decoder.decodeSerializableValue(IntentInfo.serializer())
        return IntentInfo(surrogate.passingClassName, surrogate.categories)
    }
}