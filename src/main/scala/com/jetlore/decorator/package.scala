package com.jetlore

package object decorator {

  /**
    * Contains a mapping between range types and decorators
    */
  val decoratorMap = Map(
    RangeType.Entity -> EntityDecorator,
    RangeType.TwitterUser -> TwitterUserDecorator,
    RangeType.Link -> LinkDecorator
  )

}
