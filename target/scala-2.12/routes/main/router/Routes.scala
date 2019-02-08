// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/nidhi_p/Documents/dev/RABackend/conf/routes
// @DATE:Fri Feb 08 15:20:57 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  ImageController_3: controllers.ImageController,
  // @LINE:12
  HomeController_1: controllers.HomeController,
  // @LINE:19
  UserController_4: controllers.UserController,
  // @LINE:26
  CountController_0: controllers.CountController,
  // @LINE:28
  AsyncController_2: controllers.AsyncController,
  // @LINE:31
  Assets_5: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ImageController_3: controllers.ImageController,
    // @LINE:12
    HomeController_1: controllers.HomeController,
    // @LINE:19
    UserController_4: controllers.UserController,
    // @LINE:26
    CountController_0: controllers.CountController,
    // @LINE:28
    AsyncController_2: controllers.AsyncController,
    // @LINE:31
    Assets_5: controllers.Assets
  ) = this(errorHandler, ImageController_3, HomeController_1, UserController_4, CountController_0, AsyncController_2, Assets_5, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ImageController_3, HomeController_1, UserController_4, CountController_0, AsyncController_2, Assets_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """images""", """controllers.ImageController.uploadImage()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """images/""" + "$" + """id<[^/]+>""", """controllers.ImageController.downloadImage(id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """images/""" + "$" + """id<[^/]+>""", """controllers.ImageController.deleteImage(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homes""", """controllers.HomeController.createHome()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homes/""" + "$" + """id<[^/]+>""", """controllers.HomeController.getHomeById(id:Integer)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homes/""" + "$" + """id<[^/]+>""", """controllers.HomeController.updateHomeById(id:Integer)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homes/""" + "$" + """id<[^/]+>""", """controllers.HomeController.deleteHomeById(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homes""", """controllers.HomeController.getAllHomes()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.registerUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/me""", """controllers.UserController.getCurrentUser()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/signin""", """controllers.UserController.signInUser()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/signout""", """controllers.UserController.signOutUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_ImageController_uploadImage0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images")))
  )
  private[this] lazy val controllers_ImageController_uploadImage0_invoker = createInvoker(
    ImageController_3.uploadImage(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImageController",
      "uploadImage",
      Nil,
      "POST",
      this.prefix + """images""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ImageController_downloadImage1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ImageController_downloadImage1_invoker = createInvoker(
    ImageController_3.downloadImage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImageController",
      "downloadImage",
      Seq(classOf[String]),
      "GET",
      this.prefix + """images/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ImageController_deleteImage2_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("images/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ImageController_deleteImage2_invoker = createInvoker(
    ImageController_3.deleteImage(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ImageController",
      "deleteImage",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """images/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_createHome3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homes")))
  )
  private[this] lazy val controllers_HomeController_createHome3_invoker = createInvoker(
    HomeController_1.createHome(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "createHome",
      Nil,
      "POST",
      this.prefix + """homes""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_getHomeById4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getHomeById4_invoker = createInvoker(
    HomeController_1.getHomeById(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getHomeById",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """homes/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_updateHomeById5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_updateHomeById5_invoker = createInvoker(
    HomeController_1.updateHomeById(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "updateHomeById",
      Seq(classOf[Integer]),
      "PUT",
      this.prefix + """homes/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_deleteHomeById6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_deleteHomeById6_invoker = createInvoker(
    HomeController_1.deleteHomeById(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deleteHomeById",
      Seq(classOf[Integer]),
      "DELETE",
      this.prefix + """homes/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_getAllHomes7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homes")))
  )
  private[this] lazy val controllers_HomeController_getAllHomes7_invoker = createInvoker(
    HomeController_1.getAllHomes(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getAllHomes",
      Nil,
      "GET",
      this.prefix + """homes""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_UserController_registerUser8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_registerUser8_invoker = createInvoker(
    UserController_4.registerUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "registerUser",
      Nil,
      "POST",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_UserController_getCurrentUser9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/me")))
  )
  private[this] lazy val controllers_UserController_getCurrentUser9_invoker = createInvoker(
    UserController_4.getCurrentUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getCurrentUser",
      Nil,
      "GET",
      this.prefix + """users/me""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_UserController_signInUser10_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/signin")))
  )
  private[this] lazy val controllers_UserController_signInUser10_invoker = createInvoker(
    UserController_4.signInUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "signInUser",
      Nil,
      "PUT",
      this.prefix + """users/signin""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_UserController_signOutUser11_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/signout")))
  )
  private[this] lazy val controllers_UserController_signOutUser11_invoker = createInvoker(
    UserController_4.signOutUser(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "signOutUser",
      Nil,
      "PUT",
      this.prefix + """users/signout""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_CountController_count12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count12_invoker = createInvoker(
    CountController_0.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_AsyncController_message13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message13_invoker = createInvoker(
    AsyncController_2.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_Assets_versioned14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned14_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_ImageController_uploadImage0_route(params@_) =>
      call { 
        controllers_ImageController_uploadImage0_invoker.call(ImageController_3.uploadImage())
      }
  
    // @LINE:7
    case controllers_ImageController_downloadImage1_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ImageController_downloadImage1_invoker.call(ImageController_3.downloadImage(id))
      }
  
    // @LINE:8
    case controllers_ImageController_deleteImage2_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ImageController_deleteImage2_invoker.call(ImageController_3.deleteImage(id))
      }
  
    // @LINE:12
    case controllers_HomeController_createHome3_route(params@_) =>
      call { 
        controllers_HomeController_createHome3_invoker.call(HomeController_1.createHome())
      }
  
    // @LINE:13
    case controllers_HomeController_getHomeById4_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_HomeController_getHomeById4_invoker.call(HomeController_1.getHomeById(id))
      }
  
    // @LINE:14
    case controllers_HomeController_updateHomeById5_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_HomeController_updateHomeById5_invoker.call(HomeController_1.updateHomeById(id))
      }
  
    // @LINE:15
    case controllers_HomeController_deleteHomeById6_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_HomeController_deleteHomeById6_invoker.call(HomeController_1.deleteHomeById(id))
      }
  
    // @LINE:16
    case controllers_HomeController_getAllHomes7_route(params@_) =>
      call { 
        controllers_HomeController_getAllHomes7_invoker.call(HomeController_1.getAllHomes())
      }
  
    // @LINE:19
    case controllers_UserController_registerUser8_route(params@_) =>
      call { 
        controllers_UserController_registerUser8_invoker.call(UserController_4.registerUser())
      }
  
    // @LINE:20
    case controllers_UserController_getCurrentUser9_route(params@_) =>
      call { 
        controllers_UserController_getCurrentUser9_invoker.call(UserController_4.getCurrentUser())
      }
  
    // @LINE:21
    case controllers_UserController_signInUser10_route(params@_) =>
      call { 
        controllers_UserController_signInUser10_invoker.call(UserController_4.signInUser())
      }
  
    // @LINE:22
    case controllers_UserController_signOutUser11_route(params@_) =>
      call { 
        controllers_UserController_signOutUser11_invoker.call(UserController_4.signOutUser())
      }
  
    // @LINE:26
    case controllers_CountController_count12_route(params@_) =>
      call { 
        controllers_CountController_count12_invoker.call(CountController_0.count)
      }
  
    // @LINE:28
    case controllers_AsyncController_message13_route(params@_) =>
      call { 
        controllers_AsyncController_message13_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:31
    case controllers_Assets_versioned14_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned14_invoker.call(Assets_5.versioned(path, file))
      }
  }
}
