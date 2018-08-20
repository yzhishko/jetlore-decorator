import com.jetlore.decorator.{DecorationModuleImpl, RangeItem, RangeType}
import org.scalatest._

class DecorationModuleTest extends FlatSpec{

  "A Decoration module" should "return correctly decorated text" in {
    val decorationModule = DecorationModuleImpl
    val rangeList = List(
      RangeItem(14, 22, RangeType.Entity),
      RangeItem(0, 5, RangeType.Entity),
      RangeItem(55, 67, RangeType.TwitterUser),
      RangeItem(37, 54, RangeType.Link)
    )
    val actual = decorationModule.decorate(rangeList, "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile")
    assert(actual == "<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=\"http://bit.ly/xyz\">http://bit.ly/xyz</a> @<a href=\"http://twitter.com/elversatile\">elversatile</a>")
  }

  "A Decoration module" should "return correctly decorated text without User" in {
    val decorationModule = DecorationModuleImpl
    val rangeList = List(
      RangeItem(14, 22, RangeType.Entity),
      RangeItem(0, 5, RangeType.Entity),
      RangeItem(37, 54, RangeType.Link)
    )
    val actual = decorationModule.decorate(rangeList, "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile")
    assert(actual == "<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a href=\"http://bit.ly/xyz\">http://bit.ly/xyz</a> @elversatile")
  }

  "A Decoration module" should "return correctly decorated text without Entity" in {
    val decorationModule = DecorationModuleImpl
    val rangeList = List(
      RangeItem(14, 22, RangeType.Entity),
      RangeItem(55, 67, RangeType.TwitterUser),
      RangeItem(37, 54, RangeType.Link)
    )
    val actual = decorationModule.decorate(rangeList, "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile")
    assert(actual == "Obama visited <strong>Facebook</strong> headquarters: <a href=\"http://bit.ly/xyz\">http://bit.ly/xyz</a> @<a href=\"http://twitter.com/elversatile\">elversatile</a>")
  }

}
