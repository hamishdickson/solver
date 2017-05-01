# Solver

A scalacheck version of http://clrnd.com.ar/posts/2017-04-21-the-water-jug-problem-in-hedgehog.html

```scala
scala> import solver.Solver._
import solver.Solver._

scala> solver.check
! Falsified after 93 passed tests.
> ARG_0: List("FillBig", "BigIntoSmall", "EmptySmall", "BigIntoSmall", "Fil
  lBig", "BigIntoSmall")
> ARG_0_ORIGINAL: List("FillSmall", "BigIntoSmall", "FillBig", "BigIntoSmal
  l", "BigIntoSmall", "FillBig", "EmptyBig", "FillSmall", "EmptyBig", "Fill
  Small", "FillBig", "FillBig", "SmallIntoBig", "FillSmall", "EmptySmall",
  "EmptySmall", "BigIntoSmall", "BigIntoSmall", "SmallIntoBig", "FillSmall"
  , "BigIntoSmall", "FillBig", "FillBig", "FillSmall", "FillBig", "BigIntoS
  mall", "SmallIntoBig", "EmptySmall", "FillBig", "EmptyBig", "FillSmall",
  "EmptySmall", "BigIntoSmall", "FillSmall", "FillSmall", "SmallIntoBig", "
  FillBig", "SmallIntoBig", "BigIntoSmall", "EmptySmall", "SmallIntoBig", "
  EmptySmall", "BigIntoSmall", "FillBig", "BigIntoSmall", "BigIntoSmall")
```


room for improvement - use the `State` monad here
