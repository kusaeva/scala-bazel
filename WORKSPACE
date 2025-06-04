workspace(name = "example")

scala_V = "2.13.15"

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "bazel_skylib",
    sha256 = "b8a1527901774180afc798aeb28c4634bdccf19c4d98e7bdd1ce79d1fe9aaad7",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/1.4.1/bazel-skylib-1.4.1.tar.gz",
        "https://github.com/bazelbuild/bazel-skylib/releases/download/1.4.1/bazel-skylib-1.4.1.tar.gz",
    ],
)

http_archive(
    name = "rules_python",
    sha256 = "ca2671529884e3ecb5b79d6a5608c7373a82078c3553b1fa53206e6b9dddab34",
    strip_prefix = "rules_python-0.38.0",
    url = "https://github.com/bazelbuild/rules_python/releases/download/0.38.0/rules_python-0.38.0.tar.gz",
)

load("@rules_python//python:repositories.bzl", "py_repositories")

py_repositories()

http_archive(
    name = "io_bazel_rules_scala",
    sha256 = "e734eef95cf26c0171566bdc24d83bd82bdaf8ca7873bec6ce9b0d524bdaf05d",
    strip_prefix = "rules_scala-6.6.0",
    url = "https://github.com/bazelbuild/rules_scala/releases/download/v6.6.0/rules_scala-v6.6.0.tar.gz",
)

load("@io_bazel_rules_scala//:scala_config.bzl", "scala_config")

scala_config(scala_version = scala_V)

load("@io_bazel_rules_scala//scala:scala.bzl", "rules_scala_setup", "rules_scala_toolchain_deps_repositories", "scala_repositories")

scala_repositories(
    fetch_sources = True,
    overriden_artifacts = {
        "io_bazel_rules_scala_scala_library": {
            "artifact": "org.scala-lang:scala-library:%s" % scala_V,
            "sha256": "8e4dbc3becf70d59c787118f6ad06fab6790136a0699cd6412bc9da3d336944e",
        },
        "io_bazel_rules_scala_scala_compiler": {
            "artifact": "org.scala-lang:scala-compiler:%s" % scala_V,
            "sha256": "4c200cd193c082bec14a2a2dffe6a1ba5f8130b1b27c79ee54c936dfcafc8ed9",
        },
        "io_bazel_rules_scala_scala_reflect": {
            "artifact": "org.scala-lang:scala-reflect:%s" % scala_V,
            "sha256": "78d0cc350e1ee42d87c6e11cf5b0dc7bf0b70829c00aa38f27bfb019d439dc11",
        },
    },
)

load("@io_bazel_rules_scala//scala:toolchains.bzl", "scala_register_toolchains")

scala_register_toolchains()

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()
