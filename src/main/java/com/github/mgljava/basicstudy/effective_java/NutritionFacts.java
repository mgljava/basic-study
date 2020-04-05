package com.github.mgljava.basicstudy.effective_java;

/**
 * 2. 遇到多个构造参数时要考虑构造器
 * <p>
 * 如果参数较多，可以采用JavaBean模式，先生成一个无参构造器，然后调用set方法赋值
 */
public class NutritionFacts {

  private final int servingSize;
  private final int servings;
  private final int calories;
  private final int fat;
  private final int sodium;
  private final int carbohydrate;

  public NutritionFacts(int servingSize, int servings) {
    this(servingSize, servings, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories) {
    this(servingSize, servings, calories, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories, int fat) {
    this(servingSize, servings, calories, fat, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
    this(servingSize, servings, calories, fat, sodium, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
    this.servingSize = servingSize;
    this.servings = servings;
    this.calories = calories;
    this.fat = fat;
    this.sodium = sodium;
    this.carbohydrate = carbohydrate;
  }

  // ----------上面部分采用多个构造器-----------下面部分采用建造者模式--------
  /**
   * 采用建造者模式
   */
  public static class Builder {

    // require
    private final int servingSize;
    private final int servings;

    // optional
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public Builder(int servingSize, int servings) {
      this.servings = servings;
      this.servingSize = servingSize;
    }

    public Builder calories(int val) {
      calories = val;
      return this;
    }

    public Builder fat(int val) {
      fat = val;
      return this;
    }

    public Builder sodium(int val) {
      sodium = val;
      return this;
    }

    public Builder carbohydrate(int val) {
      carbohydrate = val;
      return this;
    }

    public NutritionFacts build() {
      return new NutritionFacts(this);
    }
  }

  private NutritionFacts(Builder builder) {
    servings = builder.servings;
    servingSize = builder.servingSize;
    calories = builder.calories;
    fat = builder.fat;
    carbohydrate = builder.carbohydrate;
    sodium = builder.sodium;
  }

  public static void main(String[] args) {
    NutritionFacts nutritionFacts = new Builder(240, 8).fat(11).calories(22).carbohydrate(33).sodium(44).build();
    System.out.println(nutritionFacts);
  }
}
