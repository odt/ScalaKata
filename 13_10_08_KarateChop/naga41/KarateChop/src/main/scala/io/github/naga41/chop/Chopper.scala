package io.github.naga41.chop

object Chopper {
  def chop(target: Int, challengers: List[Int]): Int = {
    var i = 0;
    while (i < challengers.length) {
      if ( challengers(i) == target )
        return i
      i += 1
    }
    -1
  }
}
