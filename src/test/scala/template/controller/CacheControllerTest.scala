package template.controller

import com.twitter.finagle.http.Status
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.finatra.thrift.ThriftClient
import com.twitter.inject.server.FeatureTest
import com.twitter.finagle.http.Status.Ok
import template.Server
import template.domain.UserID

/**
  * Created by SangDang on 9/18/16.
  */
class CacheControllerTest extends FeatureTest {
  override protected val server = new EmbeddedHttpServer(twitterServer = new Server) with ThriftClient

  "Put cache" should {
    "successfull" in {
      server.httpPost(
        path = "/addUser",
        postBody =
          """
            {
              "user_id":{
                "id":"1"
              },
              "user_info":{
                "user_id":{
                  "id":"1"
                },
                "user_name":"test_1",
                "age":99,
                "sex":"male"
              }
            }
          """.stripMargin,
        andExpect = Ok
      )
    }
    "be able to get back" in {
      server.httpGet(
        path = "/getUser?user_id=1",
        andExpect = Status.Ok,
        withJsonBody =
          """
            {
              "user_id": {
                "id": "1"
              },
              "user_name": "test_1",
              "age": 99,
              "sex": "male"
            }
          """.stripMargin

      )
    }

  }
}
