// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/nidhi_p/Documents/dev/RABackend/conf/routes
// @DATE:Fri Feb 01 14:42:15 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
