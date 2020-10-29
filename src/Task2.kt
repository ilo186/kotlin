fun main() {

    val f1 = Fraction(30F, 4F)

    val f2 = Fraction(3F, 5F)

    println(f1 == f2)

    println(f1.simplification())
    println(f1+f2)

}

class Fraction(n: Float, d: Float) : Comparable<Fraction> {

    public var numerator: Float = n
    public var denominator: Float = d

    val decimal by lazy { numerator.toDouble() / denominator }

    override fun compareTo(other: Fraction) = decimal.compareTo(other.decimal)
    override fun equals(other: Any?): Boolean {
        if (other is Fraction) {
            if (numerator * other.denominator / denominator == other.numerator) {
                return true
            }
        }
        return false
    }
    fun gcd(a: Float , b: Float): Float {
        if(b == 0F){
            return a;
        }
        return gcd(b, a % b);
    }
    fun simplification(): String{
        var gcd = gcd(numerator,denominator);
        return (numerator / gcd).toInt().toString().plus("/").plus((denominator/ gcd).toInt().toString());
    }
    operator fun unaryMinus() = Fraction(-this.numerator, this.denominator)
    operator fun plus(add: Fraction) =
            if (this.denominator == add.denominator) Fraction(this.numerator + add.numerator, denominator)
            else {
                val a = this * add.denominator.toInt()
                val b = add * this.denominator.toInt()
                Fraction(a.numerator + b.numerator, a.denominator)
            }
    operator fun times(num: Int) = Fraction(numerator * num, denominator * num)

    //increments
    operator fun dec() = Fraction(this.numerator - 1, this.denominator)


    //invoke convention
    operator fun invoke(prefix: String = "") = println(prefix + toString())

    override fun toString(): String {
        return "$numerator/$denominator"
    }

}

operator fun Fraction.get(ind: Int) =
        when (ind) {
            0 -> numerator
            1 -> denominator
            else -> IllegalArgumentException("Index must be 0 or 1")
        }

operator fun Fraction.inc() = Fraction(this.numerator + 1, this.denominator)

operator fun ClosedRange<Fraction>.iterator() =
        object : Iterator<Fraction> {
            var curr: Fraction = start
            override fun hasNext() = curr <= endInclusive
            override fun next() = curr++

        }
