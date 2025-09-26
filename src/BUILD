load("@rules_jvm_external//:defs.bzl", "artifact")
load(
    "@rules_scala//scala:scala.bzl",
    "scala_binary",
)
load("@rules_scala//scala_proto:scala_proto.bzl", "scala_proto_library")

scala_binary(
    name = "app",
    srcs = glob([
        "**/*.scala",
    ]),
    main_class = "com.example.Main",
    deps = [
        "//src:hello_scala_proto",
    ],
)

proto_library(
    name = "hello_proto",
    srcs = ["proto/hello.proto"],
    visibility = ["//visibility:public"],
    deps = [
        "@com_google_protobuf//:empty_proto",
    ],
)

scala_proto_library(
    name = "hello_scala_proto",
    visibility = ["//visibility:public"],
    deps = [
        ":hello_proto",
    ],
)
