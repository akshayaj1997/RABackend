// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/nidhi_p/Documents/dev/RABackend/conf/routes
// @DATE:Fri Feb 01 14:42:15 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  HomeController_0: controllers.HomeController,
  // @LINE:13
  CountController_3: controllers.CountController,
  // @LINE:15
  AsyncController_2: controllers.AsyncController,
  // @LINE:18
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    HomeController_0: controllers.HomeController,
    // @LINE:13
    CountController_3: controllers.CountController,
    // @LINE:15
    AsyncController_2: controllers.AsyncController,
    // @LINE:18
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, CountController_3, AsyncController_2, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, CountController_3, AsyncController_2, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homes""", """controllers.HomeController.createHome()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homes/""" + "$" + """id<[^/]+>""", """controllers.HomeController.getHomeById(id:Integer)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homes/""" + "$" + """id<[^/]+>""", """controllers.HomeController.updateHomeById(id:Integer)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homes/""" + "$" + """id<[^/]+>""", """controllers.HomeController.deleteHomeById(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """homes""", """controllers.HomeController.getAllHomes()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_HomeController_createHome0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homes")))
  )
  private[this] lazy val controllers_HomeController_createHome0_invoker = createInvoker(
    HomeController_0.createHome(),
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

  // @LINE:6
  private[this] lazy val controllers_HomeController_getHomeById1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getHomeById1_invoker = createInvoker(
    HomeController_0.getHomeById(fakeValue[Integer]),
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

  // @LINE:7
  private[this] lazy val controllers_HomeController_updateHomeById2_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_updateHomeById2_invoker = createInvoker(
    HomeController_0.updateHomeById(fakeValue[Integer]),
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

  // @LINE:8
  private[this] lazy val controllers_HomeController_deleteHomeById3_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homes/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_deleteHomeById3_invoker = createInvoker(
    HomeController_0.deleteHomeById(fakeValue[Integer]),
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

  // @LINE:9
  private[this] lazy val controllers_HomeController_getAllHomes4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("homes")))
  )
  private[this] lazy val controllers_HomeController_getAllHomes4_invoker = createInvoker(
    HomeController_0.getAllHomes(),
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

  // @LINE:13
  private[this] lazy val controllers_CountController_count5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count5_invoker = createInvoker(
    CountController_3.count,
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

  // @LINE:15
  private[this] lazy val controllers_AsyncController_message6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message6_invoker = createInvoker(
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

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
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
  
    // @LINE:5
    case controllers_HomeController_createHome0_route(params@_) =>
      call { 
        controllers_HomeController_createHome0_invoker.call(HomeController_0.createHome())
      }
  
    // @LINE:6
    case controllers_HomeController_getHomeById1_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_HomeController_getHomeById1_invoker.call(HomeController_0.getHomeById(id))
      }
  
    // @LINE:7
    case controllers_HomeController_updateHomeById2_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_HomeController_updateHomeById2_invoker.call(HomeController_0.updateHomeById(id))
      }
  
    // @LINE:8
    case controllers_HomeController_deleteHomeById3_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_HomeController_deleteHomeById3_invoker.call(HomeController_0.deleteHomeById(id))
      }
  
    // @LINE:9
    case controllers_HomeController_getAllHomes4_route(params@_) =>
      call { 
        controllers_HomeController_getAllHomes4_invoker.call(HomeController_0.getAllHomes())
      }
  
    // @LINE:13
    case controllers_CountController_count5_route(params@_) =>
      call { 
        controllers_CountController_count5_invoker.call(CountController_3.count)
      }
  
    // @LINE:15
    case controllers_AsyncController_message6_route(params@_) =>
      call { 
        controllers_AsyncController_message6_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:18
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
