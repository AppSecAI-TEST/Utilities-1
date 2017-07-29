package com.anomalyfinder.lib.space;

/* 
 * Space to analyze
*/
/**
 */
/** "Abstract Builder" */

abstract class AbstractSpacesBuilder {
   protected Space space;

   public Space getSpace() { return space; }
   public abstract void createNewSpaceProduct();

   public abstract void buildDough();
   public abstract void buildSauce();
   public abstract void buildTopping();
}
