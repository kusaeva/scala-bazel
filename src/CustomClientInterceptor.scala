package com.example

import io.grpc._

class CustomClientInterceptor extends ClientInterceptor {
  override def interceptCall[ReqT, RespT](
                                           method: MethodDescriptor[ReqT, RespT],
                                           callOptions: CallOptions,
                                           next: Channel
                                         ): ClientCall[ReqT, RespT] = {

    val call = next.newCall(method, callOptions)

    new ForwardingClientCall.SimpleForwardingClientCall[ReqT, RespT](call) {
      override def start(responseListener: ClientCall.Listener[RespT], headers: Metadata): Unit = {
        val listener = new ForwardingClientCallListener.SimpleForwardingClientCallListener[RespT](responseListener) {
          override def onClose(status: Status, trailers: Metadata): Unit = {
            super.onClose(status, trailers)
          }
        }
        super.start(listener, headers)
      }
    }
  }
}
