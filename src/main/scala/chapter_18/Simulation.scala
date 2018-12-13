package chapter_18

//Simple simulation framework that allows actions stored in work items to install further work items
abstract class Simulation {

  //Action is an alias of a procedure that returns Unit
  //Much more readable name for type "() => Unit"
  type Action = () => Unit

  //Actions are that need to be executed at a specific time is bundled as a case class WorkItem
  case class WorkItem(time: Int, action: Action)

  //time at which an action is performed is simulated as an integer for seconds
  private var curtime = 0
  def currentTime: Int = curtime

  //List of remaining work items to be executed, sorted by simulated time to be ran
  private var agenda: List[WorkItem] = List()

  private def insert(ag: List[WorkItem], item: WorkItem): List[WorkItem] = {
    if(ag.isEmpty || item.time < ag.head.time) item :: ag
    else ag.head :: insert(ag.tail, item)
  }

  //insertions will only occur after the delay, and kept in proper order
  def afterDelay(delay: Int)(block: => Unit) = {
    //block is a formal parameter argument "=> Unit" which is a computation of type Unit, passed by name
    //by-name parameters are not evaluated when passed
    val item = WorkItem(currentTime + delay, () => block)
    agenda = insert(agenda, item)
  }

  private def next() = {
    //@unchecked annotation is to specify to compiler not to check for exhaustive match
    (agenda: @unchecked) match {
      case item :: rest =>
        agenda = rest
        curtime = item.time
        item.action()
    }
  }

  //repeatedly take first item in agenda, removes it and executes.
  //each steps calls next() to execute actions and update time/agenda
  def run() = {
    afterDelay(0){
      println("*** simulation started, time = " + currentTime + " ***")
    }
    while (!agenda.isEmpty) next()
  }
}
