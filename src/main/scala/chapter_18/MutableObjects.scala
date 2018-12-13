package chapter_18

object MutableObjects{
  //Good example of a mutable object is a bank account
  class BankAccount{
    private var bal: Int = 0

    def balance: Int = bal

    def deposit(amount: Int) = {
      require(amount > 0) //require is a parameter for
      bal += amount
    }

    def withdraw(amount: Int): Boolean = {
      if(amount > bal) false
      else{
        bal -= amount
        true
      }
    }
  }

  class Keyed{
    def computeKey: Int = 0 //some function that requires a lot of time
  }


  //Classes that contain vars may also be purely functional
  //An example would be a class that caches results of expensive operations
  class MemoKeyed extends Keyed {
    private var keyCache: Option[Int] = None
    override def computeKey: Int = {
      //Use a cache key here to save computationally expensive callls
      if(keyCache.isEmpty) keyCache = Some(super.computeKey)
      keyCache.get
    }
  }
}
