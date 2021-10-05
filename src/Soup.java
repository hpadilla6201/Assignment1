// represents types of soup
interface ISoup {

}

// types of broth in ISoup
class Broth implements ISoup {
  String type;

  Broth(String type) {
    this.type = type;
  }
  /* Fields:
   *  this.type ... String
   * 
   * Methods:
   *  none
   * Methods for Fields:
   *  none
   */
}

// types of Ingredients in ISoup
class Ingredient implements ISoup {
  ISoup more;
  String name;

  Ingredient(ISoup more, String name) {
    this.more = more;
    this.name = name;
  }
  /* Fields:
   *  this.more ... ISoup
   *  this.name ... String
   * Methods:
   *  none
   * Methods for Fields:
   *  none
   */
}

// Examples for ISoup
class ExamplesSoup {
  ISoup chicken = new Broth("chicken");
  ISoup vanilla = new Broth("vanilla");

  ISoup soup1 = new Ingredient(this.chicken, "carrots");
  ISoup soup2 = new Ingredient(this.soup1, "celery");
  ISoup yummy = new Ingredient(this.soup2, "noodles");

  ISoup soup3 = new Ingredient(this.vanilla, "horseradish");
  ISoup soup4 = new Ingredient(this.soup3, "hot dogs");
  ISoup noThankYou = new Ingredient(this.soup4, "plum sauce");

}