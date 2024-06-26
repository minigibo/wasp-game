case class WorkerWasp(hitPoints: Int = 68) extends Wasp("Worker", hitPoints, 10){
  override def createWasp(hitPoints: Int): Wasp = new WorkerWasp(hitPoints)
}