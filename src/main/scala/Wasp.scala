abstract class Wasp(name: String, hitPoints: Int, damage: Int) {

  def hit() : Wasp = {
    val newHP = hitPoints - damage
    createWasp(newHP)
  }
  
  def isDead: Boolean = hitPoints <= 0
  
  def createWasp(hitPoints: Int): Wasp
  
}
