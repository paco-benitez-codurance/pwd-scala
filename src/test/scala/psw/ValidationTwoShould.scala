package psw

import org.scalatest.flatspec._
import org.scalatest.matchers.should._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.prop.TableDrivenPropertyChecks

class ValidationTwoShould
    extends AnyFreeSpec
    with Matchers
    with TableDrivenPropertyChecks {

  val passwordValidator = PasswordValidator(PasswordValidator.validationTwo)

  val passwords =
    Table(
      ("password", "expected"),
      ("abBC123", true),
      ("abBC12", false),
      ("abcdBCD", false)
    )

  forAll(passwords) { (pwd, expected) =>
    s"$pwd should be valid $expected" in {
      passwordValidator.isValid(pwd) shouldBe expected
    }
  }

}
