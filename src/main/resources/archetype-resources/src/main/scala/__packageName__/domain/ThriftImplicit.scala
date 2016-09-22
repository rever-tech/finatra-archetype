package ${packageName}.domain

import com.twitter.util.Future
import ${packageName}.domain.thrift.{TUserID, TUserInfo}

/**
  * Created by SangDang on 9/16/16.
  */
object ThriftImplicit {
  implicit def T2UserId(tUserID: TUserID): UserID = UserID(tUserID.id)

  implicit def T2UserInfo(tUserInfo: TUserInfo): UserInfo = UserInfo(tUserInfo._1, tUserInfo.username, tUserInfo.age, tUserInfo.sex)

  implicit def UserId2T(userID: UserID): TUserID = TUserID(userID.id)

  implicit def UserInfo2T(userInfo: UserInfo): TUserInfo = TUserInfo(userInfo.userID, userInfo.userName, userInfo.age, userInfo.sex)

  implicit def Future2T(fUserInfo: Future[UserInfo]): Future[TUserInfo] = fUserInfo.map(x => x)
}
