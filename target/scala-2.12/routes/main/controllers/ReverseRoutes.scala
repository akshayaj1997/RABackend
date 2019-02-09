// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/nidhi_p/Documents/dev/RABackend/conf/routes
// @DATE:Sat Feb 09 12:52:30 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:31
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:26
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:6
  class ReverseImageController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def downloadImage(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "images/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:8
    def deleteImage(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "images/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:6
    def uploadImage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "images")
    }
  
  }

  // @LINE:19
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def getCurrentUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/me")
    }
  
    // @LINE:19
    def registerUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:22
    def signOutUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/signout")
    }
  
    // @LINE:21
    def signInUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/signin")
    }
  
  }

  // @LINE:12
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def updateHomeById(id:Integer): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "homes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:15
    def deleteHomeById(id:Integer): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "homes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:13
    def getHomeById(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "homes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:12
    def createHome(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "homes")
    }
  
    // @LINE:16
    def getAllHomes(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "homes")
    }
  
  }

  // @LINE:28
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }


}
