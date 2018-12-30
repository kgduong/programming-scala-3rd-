package chapter_20

//A first (faulty) design for a Currency class
abstract class Currency {
  val amount: Long
  def designation: String
  override def toString = amount + " " + designation

  def + (that: Currency): Currency = this
  def * (x: Double): Currency = this
}


//A second but still imperfect design of the Currency class
abstract class AbstractCurrency{
  type Currency <: AbstractCurrency //contains abstract type Currency
  val amount: Long
  def designation: String
  override def toString = amount + " " + designation
  def + (that: this.Currency): this.Currency = that
  def * (that: this.Currency): this.Currency = that

  //we can use a make factory method to create Currency we need
  def make(amount: Long): Currency //factory method
}


//currency zones for Europe and Japan
object Converter{
  var exchangeRate = Map(
    "USD" -> Map( "USD" -> 1.0,
                  "EUR" -> 0.7596,
                  "JPY" -> 1.211,
                  "CHF" -> 1.223),
    "EUR" -> Map( "USD" -> 1.316,
                  "EUR" -> 1.0,
                  "JPY" -> 1.594,
                  "CHF" -> 1.623)
  )
}

//Full implementation of currency using CurrencyZone and exchange rates for each
abstract class CurrencyZone{
  type Currency <: AbstractCurrency
  def make(x: Long): Currency

  abstract class AbstractCurrency{
    val amount: Long
    def designation: String

    def + (that: Currency): Currency = make(this.amount + that.amount)
    def * (x: Double): Currency = make((this.amount * x).toLong)
    def - (that:Currency): Currency = make(this.amount - that.amount)
    def / (that: Double) = make((this.amount / that).toLong)
    def / (that: Currency) = this.amount.toDouble / that.amount

    def from(other: CurrencyZone#AbstractCurrency): Currency =
      make(math.round(
        other.amount.toDouble * Converter.exchangeRate(other.designation)(this.designation)
      ))

    private def decimals(n: Long): Int =
      if(n == 1) 0 else 1 + decimals(n/10)

    override def toString = ((amount.toDouble/CurrencyUnit.amount.toDouble)
      formatted("%." + decimals(CurrencyUnit.amount) + "f")
      + " " + designation)

  }

  val CurrencyUnit: Currency
}
