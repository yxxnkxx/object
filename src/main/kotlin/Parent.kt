package main.kotlin

open class Parent {

    open fun test() {
        println("test: parent")
        who()
    }

   open fun who() {
        println("who: parent")
    }
}


class Child: Parent() {
    override fun who() {
       println("who: child")
    }
}

fun main() {
    val child = Child()
    child.test()
}