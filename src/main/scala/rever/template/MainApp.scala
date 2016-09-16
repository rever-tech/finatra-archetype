package rever.template

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
/**
  * Created by SangDang on 9/8/
  **/
object MainApp extends HttpServer {


  override protected def configureHttp(router: HttpRouter): Unit = {
    router.filter[CommonFilters]
  }
}
