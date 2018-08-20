package com.jetlore.decorator

import com.jetlore.decorator.RangeType.RangeType

/**
  * API class between 2nd and Decoration module
  *
  * @param start - start text position
  * @param end - end text position
  * @param rangeType - type of text object. Used to apply right Decorator
  */
case class RangeItem(start: Int, end: Int, rangeType: RangeType)

object RangeType extends Enumeration {
  type RangeType = Value
  val Entity, TwitterUser, Link = Value
}
