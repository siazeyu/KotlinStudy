

fun main(args: Array<String>) {

    /*
     * 定义变量  var str = "Hello Kotlin"
     * 多行字符串""" str """
     * ?表示允许为null
     * trimIndent()剔除每行开始和结尾的空格
     */
    var str : String? = """
        Hello Kotlin
    """.trimIndent()

    // 输出
    println("str 的值为 $str")

    // 数组定义 val类似于fina
    val arr = arrayOf(5, 2, 3, 6, 7, 9)
    println("arr = ${arr.contentToString()}")

    /* for循环
     * 1..3 = [1, 2, 3]
     * 1 until 3 = [1, 2]
     * step 表示步长 为1是可以省略
     * downTo则的类似step = -1 但是step 不允许为负数
     */
    for (i in 1 until arr.size step 2){
        println("until arr[$i] = ${arr[i]}")
    }

    for (i in arr.size - 1 downTo 0 step 2){
        println("downTo arr[$i] = ${arr[i]}")
    }


    // 避免空指针异常？，使用!!则抛出异常
    str = null
    println(str?.get(555))

    //三元表达式
    println(if (3 > 5) "3 > 5" else "3 <= 5")

    // when类似于switch
    var num = 2
    print("num = ")
    when(num){
        1 -> println(1)
        2 -> println(2)
        3 -> println(3)
        4,5 -> println("4 or 5")
        in 6..9 -> println("6..9")
        else -> println("不知道")
    }

    // list map set
    var list = listOf<Int>(7, 8, 9)
    var map = mapOf<String, String>("a" to "av", "b" to "bc")
    var set = setOf<Int>(1, 2, 2, 3, 5, 3)
    println("list: ${list.toString()}")
    println("map: ${map.toString()}")
    println("set: ${set.toString()}")

    println("end")

}