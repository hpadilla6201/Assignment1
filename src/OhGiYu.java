// represents resources in OhGiYu
interface IResource {

}

// represents a resource from IResources
class Monster implements IResource {
  String name;
  int hp;
  int attack;

  Monster(String name, int hp, int attack) {
    this.name = name;
    this.hp = hp;
    this.attack = attack;
  }
  /*
   * Fields: 
   *  this.name ... String 
   *  this.hp ... int 
   *  this.attack ... int 
   * Methods:
   *  none 
   * Methods for Fields: 
   *  none
   */
}

// represents a fusion from IResources
class Fusion implements IResource {
  String name;
  Monster monster1;
  Monster monster2;

  Fusion(String name, Monster monster1, Monster monster2) {
    this.name = name;
    this.monster1 = monster1;
    this.monster2 = monster2;
  }
  /*
   * Fields: 
   *  this.name ... String 
   *  this.monster1 ... Monster 
   *  this.monster2 ... Monster 
   * Methods: 
   *  none 
   * Methods for Fields: 
   *  none
   */
}

// represents a trap from IResources
class Trap implements IResource {
  String description;
  boolean continuous;

  Trap(String description, boolean continuous) {
    this.description = description;
    this.continuous = continuous;
  }
  /*
   * Fields: 
   *  this.description ... String 
   *  this.continuous ... boolean
   * 
   * Methods: 
   *  none 
   * Methods for Fields: 
   *  none
   */

}

// represents action performed in a OhGiYu game
interface IAction {

}

// represents one of the actions in IAction
class Attack implements IAction {
  IResource attacker;
  IResource defender;

  Attack(IResource attacker, IResource defender) {
    this.attacker = attacker;
    this.defender = defender;
  }
  /*
   * Fields: 
   *  this.attacker ... IResources 
   *  this.defender ... IResources
   * 
   * Methods: 
   *  none 
   * 
   * Methods for Fields: 
   *  none
   */
}

// represents on the actions in IAction
class Activate implements IAction {
  Trap trap;
  IResource target;

  Activate(Trap trap, IResource target) {
    this.trap = trap;
    this.target = target;
  }
  /*
   * Fields: this.trap ... Trap 
   * this.target ... IResources
   * 
   * Methods: 
   *  none 
   * Methods for Fields: 
   *  none
   */
}

// examples for OhGiYu game
class ExamplesGame {

  Monster itachi = new Monster("Itachi", 10, 10);
  Monster sasuke = new Monster("Sasuke", 100, 100);
  Monster kuriboh = new Monster("Kuriboh", 200, 100);
  Monster jinzo = new Monster("Jinzo", 500, 400);
  Monster hector = new Monster("Hector", 1000, 750);
  Fusion kurizo = new Fusion("Kurizo", this.kuriboh, this.jinzo);
  Trap trapHole = new Trap("Kills a monster", false);
  Trap holeTrap = new Trap("Kills a fusion", true);

  IAction attack1 = new Attack(this.hector, this.kuriboh);
  IAction attack2 = new Attack(this.kurizo, this.itachi);
  IAction activate1 = new Activate(new Trap("Kills a fusion", true), this.kurizo);
  IAction activate2 = new Activate(new Trap("Kills a monster", false), this.itachi);
  /*
   * This was not a good data design because instead of using IResource
   * as the data type of each Monster, Fusion, and Trap, the data type
   * needed to be declared to its concrete class such as Fusion, Monster, and Trap. 
   * 
   * For Example, when trying to instantiate a new Fusion, because the Fusion
   * class is needs two Monsters it would not be able to take in a data type of 
   * IResource even though an IResource could be a Monster. 
   * 
   * An alternative design would probably to make the Fusion class instead 
   * of having data type of two Monsters, have those data types be IResources instead.
   * This way when instantiating a new Trap, it would be able to take a Monster of 
   * IResource type. The only flaw to this solution would be that there is no restraint
   * for the user to only pick two Monsters when instantiating a new Fusion.
   * 
   */

}

