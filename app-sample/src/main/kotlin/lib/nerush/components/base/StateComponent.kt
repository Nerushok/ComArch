package lib.nerush.components.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import lib.nerush.components.library.BaseComponent

abstract class StateComponent<S>(
    initialState: S,
) : BaseComponent<S>(), StateDelegate<S> {

    private val stateDelegate = StateDelegateImpl(initialState)
    override val stateFlow: StateFlow<S>
        get() = stateDelegate.stateFlow

    override fun updateState(reducer: S.() -> S) = stateDelegate.updateState(reducer)

    protected fun <T> Flow<T>.updateStateOnEach(reducer: S.(T) -> S) {
        onEach { updateState { reducer(it) } }.launchIn(coroutineScope)
    }
}
