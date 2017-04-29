package solver

import org.scalacheck.Gen
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object Solver extends Properties("String") {

  sealed trait Step
  case object FillBig extends Step
  case object FillSmall extends Step
  case object EmptyBig extends Step
  case object EmptySmall extends Step
  case object SmallIntoBig extends Step
  case object BigIntoSmall extends Step

  case class Jugs(bigJug: Int, smallJug: Int)

  lazy val initState = Jugs(0, 0)

  def fsm(jug: Jugs, step: Step): Jugs = (jug, step) match {
    case (j, FillBig)    => Jugs(5, j.smallJug)
    case (j, FillSmall)  => Jugs(j.bigJug, 3)
    case (j, EmptyBig)   => Jugs(0, j.smallJug)
    case (j, EmptySmall) => Jugs(j.bigJug, 0)
    case (Jugs(big, small), SmallIntoBig) => {
      val b = math.min(5, big + small)
      val s = small - (b - big)
      Jugs(b, s)
    }
    case (Jugs(big, small), BigIntoSmall) => {
      val s = math.min(3, big + small)
      val b = big - (s - small)
      Jugs(b, s)
    }
  }

  val program = (ss: List[Step]) => ss.foldLeft(initState)(fsm)

  // hmmm...
  val gs = Gen.oneOf(FillBig, FillSmall, EmptyBig, EmptySmall, SmallIntoBig, BigIntoSmall)

  val steps = Gen.listOf(gs)

  def solver = forAll(steps) { s =>
    program(s).bigJug != 4
  }
}
