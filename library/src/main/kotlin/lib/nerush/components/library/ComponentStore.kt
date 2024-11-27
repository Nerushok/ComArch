package lib.nerush.components.library

open class ComponentStore {

    private val map = mutableMapOf<String, Component>()

    fun put(key: String, component: Component) {
        val oldComponent = map.put(key, component)
        oldComponent?.clear()
    }

    fun put(component: Component): Component {
        put(component.key, component)
        return component
    }

    fun remove(key: String) {
        map.remove(key)?.clear()
    }

    fun remove(component: Component) {
        remove(component.key)
    }

    operator fun get(key: String): Component? {
        return map[key]
    }

    fun clear() {
        for (component in map.values) {
            component.clear()
        }
        map.clear()
    }

    private val Component.key: String
        get() = this::class.java.canonicalName
            ?: throw IllegalArgumentException("Local and anonymous classes can not be Component")
}
