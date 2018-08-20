package com.jetlore.decorator

object DecorationModuleImpl extends DecorationModule {

  override def decorate(rangeItems: List[RangeItem], input: String): String = {
    //Sort ranges first
    val sortedRangeItems = rangeItems.sortWith(_.start > _.start)
    //Let's fold results and pass last index of decorated text
    val result = sortedRangeItems.foldRight((new StringBuilder(), 0)) {
      case (rangeItem, (res, lastIndex)) =>
        //Take undecorated text first
        val undecoratedText = input.substring(lastIndex, rangeItem.start)
        res.append(undecoratedText)
        //Take text to decorate
        val textToDecorate = input.substring(rangeItem.start, rangeItem.end)
        //Perform decoration and append to result
        res.append(decorate(textToDecorate, rangeItem))
        (res, rangeItem.end)
    }
    result._1.append(input.substring(result._2)).toString()
  }

  /**
    * Decorate specific text within a range
    *
    * @param input - text
    * @param item - @RangeItem object
    * @return decorrated
    */
  private def decorate(input: String, item: RangeItem): String = {
    decoratorMap(item.rangeType).decorate(input)
  }

}
