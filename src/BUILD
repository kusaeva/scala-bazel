load("@rules_jvm_external//:defs.bzl", "artifact")
load(
    "@rules_scala//scala:scala.bzl",
    "scala_binary",
)

scala_binary(
    name = "app",
    srcs = glob([
        "**/*.scala",
    ]),
    main_class = "main.Main",
    plugins = [
        "@maven//:com_olegpy_better_monadic_for_2_13",
    ],
    deps = [
        "@maven//:dev_zio_izumi_reflect_2_13",
        "@maven//:dev_zio_zio_2_13",
        "@maven//:dev_zio_zio_stacktracer_2_13",
    ],
)
