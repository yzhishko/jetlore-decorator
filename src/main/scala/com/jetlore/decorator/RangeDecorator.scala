package com.jetlore.decorator

/**
  * Inherit classes should implement @RangeDecorator.decorate method to provide right wrapping
  */
abstract class RangeDecorator {

  def decorate(input: String): String

}

object EntityDecorator extends RangeDecorator {
  override def decorate(input: String): String = {
    "<strong>" + input + "</strong>"
  }
}

object LinkDecorator extends RangeDecorator {
  override def decorate(input: String): String = {
    "<a href=\"" + input + "\">" + input + "</a>"
  }
}

object TwitterUserDecorator extends RangeDecorator {
  override def decorate(input: String): String = {
    val link = input.substring(0,1)
    val name= input.substring(1)
    link + "<a href=\"http://twitter.com/" + name +"\">" + name + "</a>"
  }
}