case class DroneWasp(hitPoints: Int = 60) extends Wasp("Drone", hitPoints, 12){
  override def createWasp(hitPoints: Int): Wasp = new DroneWasp(hitPoints)
}