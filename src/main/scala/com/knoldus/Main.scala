package com.knoldus

import com.knoldus.abstracts.{Email, Logging}
import com.knoldus.implementations.{LoggingLive, MockEmail}
import zio.internal.Platform
import zio.{ExitCode, Has, Runtime, URIO}

object Main extends scala.App {
  val customRuntime = Runtime(
    Has.allOf[Logging, Email](LoggingLive(), MockEmail()),
    Platform.default
  )

  // the custom runtime can also be created using default runtime as follows:
  val customRuntimeFromDefault = Runtime.default.map((zenv: zio.ZEnv) =>
    zenv ++ Has.allOf[Logging, Email](LoggingLive(), MockEmail())
  )

  customRuntime.unsafeRun(
    for{
      _ <- Logging.log("Demo application started !")
      _ <- Logging.log("This is a sample log. Will be sending a mock email now. ")
      _ <- Email.send("test.user@dummy.com", "This is a mock email.")
    }yield()
  )
}