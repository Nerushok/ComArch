package lib.nerush.components.base

import androidx.lifecycle.ViewModel
import lib.nerush.components.library.ComponentStore
import lib.nerush.components.library.ComponentStoreOwner

abstract class BaseViewModel(
    override val componentStore: ComponentStore = ComponentStore(),
) : ViewModel(), ComponentStoreOwner {

    override fun onCleared() {
        componentStore.clear()
        super.onCleared()
    }
}