package template.controller.http

import javax.inject.{Inject, Singleton}

import com.twitter.finatra.http.Controller
import template.domain.{GetCacheRequest, PutCacheRequest}
import template.service.UserCacheService


/**
  * Created by SangDang on 9/16/16.
  */

@Singleton
class CacheController @Inject()(userCacheService: UserCacheService) extends Controller {
  post("/addUser") { request: PutCacheRequest =>
    userCacheService.addUser(request.userID, request.userInfo)
  }
  get("/getUser") {
    request: GetCacheRequest =>
      for {
        userInfo <- userCacheService.getUser(request.userID)
      } yield {
        response.ok(userInfo)
      }
  }
}
