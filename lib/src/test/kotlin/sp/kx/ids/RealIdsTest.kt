package sp.kx.ids

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RealIdsTest {
    @Test
    fun randomTest() {
        val ids: Ids = RealIds()
        assertEquals(16 * 2 + 4, ids.random().toString().length)
    }
}
