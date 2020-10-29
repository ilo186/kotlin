fun main() {

    val firstPoint = Point(6F, 8F)
    val secondPoint = Point(4F, 4F)

    println(firstPoint.area())
    println(secondPoint.area())
    println(firstPoint == secondPoint)

}

class Point(x: Float, y: Float) {

    private var horizontal: Float = x
    private var vertical: Float = y

    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            if (horizontal * other.vertical / vertical == other.horizontal) {
                return true
            }
        }
        return false
    }
    fun area(): Float{
        return horizontal*vertical/2
    }
    override fun toString(): String {
        return "$horizontal/$vertical"
    }

}