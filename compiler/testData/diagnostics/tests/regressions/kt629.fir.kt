//KT-629 Assignments are parsed as expressions.

package kt629

class A() {
    var p = "yeah"
    operator fun rem(other : A) : A {
        return A();
    }
}

fun box() : Boolean {
    var c = A()
    val d = c;
    c %= A();
    return (c != d) && (c.p = "yeah")
}


fun box2() : Boolean {
    var c = A()
    return (c.p = "yeah") && true
}
