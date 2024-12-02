package lib.nerush.components.library

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseComponent<S>(
    storeOwner: ComponentStoreOwner,
    override val componentStore: ComponentStore = ComponentStore(),
    override val coroutineScope: CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate),
) : Component {

    init {
        storeOwner.attachComponent(this)
    }
}
