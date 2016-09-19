package template.controller

import java.net.InetSocketAddress

import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.http.Status
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.finatra.thrift.ThriftClient
import com.twitter.inject.server.FeatureTest
import com.twitter.finagle.http.Status.Ok
import com.twitter.finagle.thrift.ThriftClientFramedCodec
import com.twitter.util.Future
import org.scalatest.Assertions
import template.Server
import template.domain.UserID
import template.domain.thrift.{TUserID, TUserInfo}
import template.service.TUserCacheService.FinagledClient
import template.service.{TUserCacheService, UserCacheService}

/**
  * Created by SangDang on 9/18/16.
  */
class CacheControllerTest extends FeatureTest {
  override protected val server = new EmbeddedHttpServer(twitterServer = new Server) with ThriftClient

  "[HTTP] Put cache" should {
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
  "[Thrift] put cache" should {
    lazy val client = server.thriftClient[TUserCacheService[Future]](clientId = "1")
    "successful" in {
      client.addUser(TUserInfo(TUserID("101"), "test", 100, "male"))
      client.getUser(TUserID("101")).onSuccess(userInfo => {
        Assertions.assert(userInfo.userId.equals("101"))
        Assertions.assert(userInfo.username.equals("test"))
        Assertions.assert(userInfo.age.equals(100))
        Assertions.assert(userInfo.sex.equals("male"))
      }).onFailure(fn => throw fn)

    }
  }

  "[Thrift] external put cache" should {
    lazy val clientService = ClientBuilder()
      .hosts(Seq(new InetSocketAddress("localhost", server.thriftExternalPort)))
      .codec(ThriftClientFramedCodec())
      .hostConnectionLimit(1)
      .build()
    val client = new FinagledClient(clientService)
    "successful" in {
      client.addUser(TUserInfo(TUserID("111"), "t_test", 101, "female"))
      client.getUser(TUserID("111")).onSuccess(userInfo => {
        Assertions.assert(userInfo.userId.equals("111"))
        Assertions.assert(userInfo.username.equals("t_test"))
        Assertions.assert(userInfo.age.equals(101))
        Assertions.assert(userInfo.sex.equals("female"))
      }).onFailure(fn => throw fn)

    }
  }

}
