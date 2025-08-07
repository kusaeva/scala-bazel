package main

import example.Example

import java.io.IOException
import zio.{Console, IO, ZIOAppDefault}

object Main extends ZIOAppDefault {
  def run: IO[IOException, Unit] = Console.printLine(Example.text)
}
