load(
    "@io_bazel_rules_scala//scala:scala.bzl",
    "scala_binary",
)

scala_binary(
    name = "app",
    srcs = glob([
        "**/*.scala",
    ]),
    main_class = "main.Main",
    scalacopts = ["-Xsource:3"],
)
