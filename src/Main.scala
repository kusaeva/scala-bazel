package com.example

import io.grpc._
import com.example.protos._
import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.duration._

object Main extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global

  val channel: ManagedChannel = ManagedChannelBuilder
    .forAddress("localhost", 50051)
    .usePlaintext()
    .intercept(new CustomClientInterceptor())
    .build()

  try {
    val asyncStub = HelloServiceGrpc.stub(channel)
    val futureResponse: Future[HelloResponse] =
      asyncStub.sayHello(HelloRequest("World"))
    scala.concurrent.Await.result(futureResponse, 5.seconds)
  } catch {
    case e: io.grpc.StatusRuntimeException => println("ok, unavailable")
  } finally {
    channel.shutdown()
  }
}
