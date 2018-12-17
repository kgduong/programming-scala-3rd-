package chapter_18

object MySimulation extends CircuitSimulation {

  override def InverterDelay = 1
  override def AndGateDelay = 3
  override def OrGateDelay = 5

}