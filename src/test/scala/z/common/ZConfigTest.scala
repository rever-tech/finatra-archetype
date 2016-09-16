package z.common

import com.twitter.inject.Test
import com.twitter.inject.server.{EmbeddedTwitterServer, FeatureTest}
import org.junit.Assert

/**
  * Created by SangDang on 9/15/16.
  */
class ZConfigTest extends Test{
  System.setProperty("mode","test")
  "ZConfig" should {
    "init successful with test.conf" in {
      Assert.assertEquals("should in test mode",ZConfig.env,"test")
    }
  }
  "[Int Test]" should {
    "get exist value successful" in {
      Assert.assertEquals(ZConfig.getInt("ZConfigTest.test_int.var"),1)
    }
    "get non-exist value should return default value" in {
      Assert.assertEquals(ZConfig.getInt("ZConfigTest.test_int.not_exist_conf",404),404)
    }
    "get list value successful" in {
      Assert.assertArrayEquals(ZConfig.getIntList("ZConfigTest.test_int.vars").toArray,Array(1,2,4,5))
    }
    "get non-exist list value should return default value" in {
      Assert.assertArrayEquals(ZConfig.getIntList("ZConfigTest.test_int.non_exist_vars",Seq(1,2,4,5)).toArray,Array(1,2,4,5))
    }
  }
}
