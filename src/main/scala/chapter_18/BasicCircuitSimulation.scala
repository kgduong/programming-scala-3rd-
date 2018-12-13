package chapter_18

abstract class BasicCircuitSimulation extends Simulation{

  //3 abstract methods representing delays of our basic gates
  //Actual delays are not known at this level, since they depend on the actual circuits
  def InverterDelay: Int
  def AndGateDelay: Int
  def OrGateDelay: Int

  class Wire{

    //make up the state of the wire
    private var sigVal = false
    private var actions: List[Action] = List()

    //returns current signal on wire
    def getSignal = sigVal

    //set wire's signal
    def setSignal(s: Boolean) {
      if (s != sigVal) {
        sigVal = s
        actions foreach (_ ()) //run each actions
      }
    }

    def addAction(a: Action) {
      actions = a :: actions
      a()
    }
  }

  //Grabs the signal and installs another action that inverts the output signal
  def inverter(input: Wire, output: Wire) = {
    def invertAction() = {
      val inputSig = input.getSignal
      afterDelay(InverterDelay){
        //set's the input value to the inverse of it
        output setSignal !inputSig
      }
    }
    input addAction invertAction
  }

  def andGate(a1: Wire, a2: Wire, output: Wire) = {
    def andAction() = {
      val a1Sig = a1.getSignal
      val a2Sig = a2.getSignal
      afterDelay(AndGateDelay){
        output setSignal(a1Sig & a2Sig)
      }
    }
    a1 addAction andAction
    a2 addAction andAction
  }

  def orGate(o1: Wire, o2: Wire, output: Wire)= {
    def orAction() = {
      val o1Sig = o1.getSignal
      val o2Sig = o2.getSignal
      afterdelay(OrGateDelay){
        output setSignal(o1Sig | o2Sig)
      }
    }
    o1 addAction orAction
    o2 addAction orAction
  }

  //Probe is used to inspect changes of signal on wires
  //The probe action is executed every time the wire's signal changes
  def probe(name: String, wire: String) = {
    def probeAction() = {
      println(name + " " + currentTime + " new-value = " + wire.getSignal)
    }
    wire addAction probeAction
  }

}
