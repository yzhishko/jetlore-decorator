package com.jetlore.decorator

abstract class DecorationModule {

  /**
    *
    * Applies decoration based on output from previous modules
    *
    * @param rangeItems - List of @RangeItem objects to decorate
    * @param input - Input string to decorate
    * @return decorated string
    */
  def decorate(rangeItems: List[RangeItem], input: String): String

}