package controllers

import javax.inject._
import play.api.data.Form
import play.api.mvc._
import play.api.data.Forms._
import play.api.i18n.I18nSupport
//import de.htwg.scala.Pentago.controller.Controller
//import de.htwg.scala.Pentago.model.Player

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
case class GameData(name1: String, name2: String)

  object GameData {
    val form: Form[GameData] = Form(
      mapping(
        "name1" -> text,
        "name2" -> text
      )(GameData.apply)(GameData.unapply)
    )
  }

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {


  private var playerName1 = "Player 1"
  private var playerName2 = "Player 2"
  //private val controller = new Controller(playerName1, playerName2)

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  def index = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(GameData.form))
  }

  def playground = Action { implicit request =>
    println("test")
    Ok(views.html.playground())
  }

  /*
  def nextSide = Action {
  controller.players(0) = new Player(1, "")
  controller.players(1) = new Player(2, "")
  controller.currentPlayer = controller.players(0)
  }
  */

}
