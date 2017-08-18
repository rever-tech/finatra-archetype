package ${package}.domain

import com.twitter.finatra.request.QueryParam

/**
  * Created by SangDang on 9/16/16.
  */
case class PutCacheRequest(userID: UserID,userInfo: UserInfo) {
}
case class GetCacheRequest( @QueryParam userID: String) {
}
