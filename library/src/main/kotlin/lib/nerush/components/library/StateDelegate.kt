package lib.nerush.components.library

import kotlinx.coroutines.flow.StateFlow

interface StateDelegate<S> {

    val stateFlow: StateFlow<S>
    val state: S
        get() = stateFlow.value

    fun updateState(reducer: S.() -> S)
}
