package sp.kx.ids

import java.security.SecureRandom
import java.util.UUID

class RealIds(private val ng: SecureRandom) : Ids {
    override fun random(): UUID {
        val bytes = ByteArray(16)
        ng.nextBytes(bytes)
        bytes[6] = bytes[6].toInt().and(0x0f).toByte() /* clear version       */
        bytes[6] = bytes[6].toInt().or(0x40).toByte()  /* set to version 4    */
        bytes[8] = bytes[8].toInt().and(0x3f).toByte() /* clear variant       */
        bytes[8] = bytes[8].toInt().or(0x80).toByte()  /* set to IETF variant */
        val mostSigBits = (0 until 8).fold(0L) { acc, index ->
            acc.shl(8).or(bytes[index].toLong().and(0xff))
        }
        val leastSigBits = (0 until 16).fold(0L) { acc, index ->
            acc.shl(8).or(bytes[index].toLong().and(0xff))
        }
        return UUID(mostSigBits, leastSigBits)
    }
}
