package ${package}.controller

import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.finatra.thrift.ThriftClient
import com.twitter.inject.server.{EmbeddedTwitterServer, FeatureTest}
import ${package}.Server
import com.twitter.finagle.http.Status
/**
  * Created by SangDang on 9/18/16.
  */
class HealthControllerTest extends FeatureTest{
  override protected def server = new EmbeddedHttpServer(twitterServer = new Server) with ThriftClient

  "Test Health Http" in {
    server.httpGet(path = "/ping",andExpect = Status.Ok, withJsonBody =
      """
        {
          "status":"ok",
          "data":"pong"
        }
      """.stripMargin)

  }
}