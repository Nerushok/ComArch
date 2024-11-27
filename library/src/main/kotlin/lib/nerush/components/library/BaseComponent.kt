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
) : Component, StateDelegate<S> {

    init {
        storeOwner.attachComponent(this)
    }
}

abstract class StateComponent<S>(
    storeOwner: ComponentStoreOwner,
    initialState: S,
) : BaseComponent<S>(storeOwner), StateDelegate<S> {

    private val stateDelegate = StateDelegateImpl(initialState)
    override val stateFlow: StateFlow<S>
        get() = stateDelegate.stateFlow

    override fun updateState(reducer: S.() -> S) = stateDelegate.updateState(reducer)

    protected fun <T> Flow<T>.updateStateOnEach(reducer: S.(T) -> S) {
        onEach { updateState { reducer(it) } }.launchIn(coroutineScope)
    }
}
