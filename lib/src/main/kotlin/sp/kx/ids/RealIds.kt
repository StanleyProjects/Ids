package sp.kx.ids

import java.util.UUID

class RealIds : Ids {
    override fun random(): UUID {
        return UUID.randomUUID()
    }
}
