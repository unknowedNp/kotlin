// IGNORE_BACKEND_FIR: JVM_IR
// TARGET_BACKEND: JVM
// FILE: test.kt
// WITH_RUNTIME

import kotlin.test.*

private operator fun A.inc() = A()

fun box(): String {
    assertFailsWith<NullPointerException> {
        var aNull = A.n()
        aNull++
    }

    return "OK"
}

// FILE: A.java
public class A {
    public static A n() { return null; }
}
