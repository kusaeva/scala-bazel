`bazel run //src:app` for scala 3 fails with 
```
Exception in thread "grpc-default-executor-1" java.lang.IllegalAccessError: failed to access class io.grpc.PartialForwardingClientCallListener from class com.example.CustomClientInterceptor$$anon$2 (io.grpc.PartialForwardingClientCallListener and com.example.CustomClientInterceptor$$anon$2 are in unnamed module of loader 'app')
	at com.example.CustomClientInterceptor$$anon$2.onClose(CustomClientInterceptor.scala:18)
	at io.grpc.internal.DelayedClientCall$DelayedListener$3.run(DelayedClientCall.java:487)
	at io.grpc.internal.DelayedClientCall$DelayedListener.delayOrExecute(DelayedClientCall.java:451)
	at io.grpc.internal.DelayedClientCall$DelayedListener.onClose(DelayedClientCall.java:484)
	at io.grpc.internal.ClientCallImpl.closeObserver(ClientCallImpl.java:565)
	at io.grpc.internal.ClientCallImpl.access$100(ClientCallImpl.java:72)
	at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInternal(ClientCallImpl.java:733)
	at io.grpc.internal.ClientCallImpl$ClientStreamListenerImpl$1StreamClosed.runInContext(ClientCallImpl.java:714)
	at io.grpc.internal.ContextRunnable.run(ContextRunnable.java:37)
	at io.grpc.internal.SerializingExecutor.run(SerializingExecutor.java:133)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
Exception in thread "main" java.lang.ExceptionInInitializerError
	at com.example.Main.main(Main.scala)
Caused by: java.util.concurrent.TimeoutException: Future timed out after [5 seconds]
	at scala.concurrent.impl.Promise$DefaultPromise.tryAwait0(Promise.scala:248)
	at scala.concurrent.impl.Promise$DefaultPromise.result(Promise.scala:261)
	at scala.concurrent.Await$.$anonfun$result$1(package.scala:201)
	at scala.concurrent.BlockContext$DefaultBlockContext$.blockOn(BlockContext.scala:62)
	at scala.concurrent.Await$.result(package.scala:124)
	at com.example.Main$.<clinit>(Main.scala:21)
	... 1 more
```
but it works with scala 2.13.16

Changing package of CustomClientInterceptor to `io.grpc` helps
