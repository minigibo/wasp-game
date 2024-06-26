case class QueenWasp(hitPoints: Int = 80) extends Wasp("Queen", hitPoints, 7){
  override def createWasp(hitPoints: Int): Wasp = new QueenWasp(hitPoints)
}
