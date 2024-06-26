object WaspNest {

  def initialiseWasps(): List[Wasp] = {
    ( QueenWasp() :: List.fill(5)( WorkerWasp()) ::: List.fill(8)( DroneWasp()))
  }

  def displayNest(wasps: List[Wasp], noOfHits: Int): Unit = {
    println("___________________________________")
    println(s"Current Wasp Nest State:")
    wasps.foreach{
      case QueenWasp(hitPoints)   => println(s"Queen Wasp: HP = $hitPoints")
      case WorkerWasp(hitPoints)  => println(s"Worker Wasp: HP = $hitPoints")
      case DroneWasp(hitPoints)   => println(s"Drone Wasp: HP = $hitPoints")
    }
    println(s"Total hits: $noOfHits")
  }
}
