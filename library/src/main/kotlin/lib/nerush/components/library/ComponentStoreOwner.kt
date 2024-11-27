package lib.nerush.components.library

interface ComponentStoreOwner {

    val componentStore: ComponentStore

    fun attachComponent(component: Component) {
        componentStore.put(component)
    }

    fun attachComponent(key: String, component: Component) {
        componentStore.put(key, component)
    }

    fun detachComponent(component: Component) {
        componentStore.remove(component)
    }

    fun detachComponent(key: String) {
        componentStore.remove(key)
    }

    fun clearComponents() {
        componentStore.clear()
    }
}