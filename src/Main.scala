package main


import java.io.IOException
import zio.{Console, IO, Task, ZIO, ZIOAppDefault}

object Main extends ZIOAppDefault {

  val example: Task[String] =
    for {
      (_,bar) <- get
    } yield bar

  def get: Task[(String, String)] = ZIO.attempt("foo" -> "success")

  def run: IO[IOException, Unit] =
      example.flatMap(x => Console.printLine(x)).ignore
}
