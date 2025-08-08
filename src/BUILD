load("@rules_jvm_external//:defs.bzl", "artifact")
load(
    "@rules_scala//scala:scala.bzl",
    "scala_binary",
)

scala_binary(
    name = "app3",
    srcs = glob([
        "**/*.scala",
    ]),
    main_class = "main.Main",
    deps = [
        "@maven//:dev_zio_izumi_reflect_3",
        "@maven//:dev_zio_zio_3",
        "@maven//:dev_zio_zio_stacktracer_3",
    ],
)

scala_binary(
    name = "app",
    srcs = glob([
        "**/*.scala",
    ]),
    main_class = "main.Main",
    scala_version = "2.13.16",
    deps = [
        "@maven//:dev_zio_izumi_reflect_2_13",
        "@maven//:dev_zio_zio_2_13",
        "@maven//:dev_zio_zio_stacktracer_2_13",
    ],
)
