/*
 * 不加open表示这个类为final不允许被继承
 * 加上var或val修饰表示name为属性,但是只能在主构造方法使用
 * 其他地方还是得用 this.variable = variable
 * 主构造器表示一定会调用的构造器，一般将属性填入其中
 */
open class A(var name: String?) {

    /*
     * companion object表示为static
     * 静态常量使用const val修饰，不要使用val，效果一样
     * 但不加const其实是一个private static变量，通过方法调用
     */
    companion object{
        var age : Int = 666
        const val sex = "男"
    }

}

// : 表示继承或实现关系 相当与 public final class B extends A implements Runnable
class B : A, Runnable{

    /*
     * lateinit 表示延迟加载如果使用时没有被赋值就会抛出异常
     */
    private lateinit var hobby: Array<String>

    /*
     * init初始化操作，执行顺序 主构造 -> init -> 次构造器
     */
    init {
        hobby = emptyArray()
    }


    constructor(name: String?): super(name){
        print("有参构造: ")
        this.print()
    }

    constructor(name: String?, hobby: Array<String>): super(name){
        this.hobby = hobby
        print("有参构造: ")
        this.print()
    }

    constructor() : super(null){
        print("无参构造: ")
        this.print()
    }


    private fun print() {
        println("$name $age $sex ${hobby.contentToString()}")
    }

    override fun run() {
        TODO("Not yet implemented")
        println("run")
    }

}

fun main(args: Array<String>) {

    A.age = 18
    B()
    B("Bob")
    B("Alice", arrayOf("唱","跳" ,"rap" ,"篮球"))

}