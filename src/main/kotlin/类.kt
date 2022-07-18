/*
 * 不加open表示这个类为final不允许被继承
 * 加上var或val修饰表示name为属性,但是只能在主构造方法使用
 * 其他地方还是得用 this.variable = variable
 * 主构造器表示一定会调用的构造器，一般将属性填入其中
 */
open class A(open var name: String?) {



    /*
     * companion object表示为static
     * 静态常量使用const val修饰，不要使用val，效果一样
     * 但不加const其实是一个private static变量，通过方法调用
     */
    companion object{
        /*
         * by lazy 只能用来修饰val变量，只在首次调用的时候触发一次
         * 可选择模式
         * SYNCHRONIZED 同步模式，线程安全
         * PUBLICATION 公共模式，允许多个线程初始化，但是只有一个有效
         * NONE 会多次调用，且会改变常量的值为最后一次值线程不安全
         */
        val lazyValue: String by lazy (LazyThreadSafetyMode.NONE){
            println("lazyValue 加载")
            (++age).toString()
        }
        var age : Int = 18
        const val sex = "男"
    }

}

// : 表示继承或实现关系 相当与 public final class B extends A implements Runnable
class B : A, Runnable{

    /*
     * 属性get和set方法 field 为内置变量表示name的值，
     * 不能直接使用name，否则死循环导致栈溢出
     * 因为我们在调用 .name时就是调用get方法
     */
     override var name: String? = null
         get() {
             return "name: $field"
        }
        set(value) {
            // 表示如果value == null 返回 "default name"
            field = value ?: "default name"
        }

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
        this.name = name
        print("有参构造: ")
        this.print()
    }

    constructor(name: String?, hobby: Array<String>): this(name){
        this.hobby = hobby
        print("有参构造: ")
        this.print()
    }

    constructor() : super(null){
        print("无参构造: ")
    }


    private fun print() {
        println("$name $age $sex ${hobby.contentToString()}")
    }

    override fun run() {
        TODO("Not yet implemented")
        println("run")
    }

}

/*
 * 数组 表示展开接收参数的类型需要时varargs
 * Kotlin函数参数默认为final不允进行赋值操作
 */
fun main(args: Array<String>) {
    // 首次调用出发lazy
    A.lazyValue
    // 不触发
    A.lazyValue
    A.lazyValue
    B()
    B("Bob")
    B("Alice", arrayOf("唱","跳" ,"rap" ,"篮球"))

}
