package io.github.joker1007

/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 13/10/11
 * Time: 14:05
 * To change this template use File | Settings | File Templates.
 */
object App {
  def main(args: Array[String]) {
    println(ParticipantCollection.parseFileList(args(0)).onDate(Date(2013, 10, 9)))
  }
}
