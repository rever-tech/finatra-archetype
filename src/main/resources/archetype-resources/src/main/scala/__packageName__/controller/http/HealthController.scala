package ${packageName}.controller.http

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

import scala.util.parsing.json.JSONObject

/**
  * Created by SangDang on 9/18/16.
  */
class HealthController extends Controller {
  get("/ping") {
    request: Request => {
      logger.error("ping")
      response.ok(JSONObject(Map("status"->"ok","data"->"pong")).toString())
    }
  }
}
