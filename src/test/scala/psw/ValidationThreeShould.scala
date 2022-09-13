package psw

import org.scalatest.flatspec._
import org.scalatest.matchers.should._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.prop.TableDrivenPropertyChecks

class ValidationThreeShould
    extends AnyFreeSpec
    with Matchers
    with TableDrivenPropertyChecks {

  val passwordValidator = PasswordValidator(PasswordValidator.validationThree)

  val passwords =
    Table(
      ("password", "expected"),
      ("abcdefABCDEF12345", true),
      ("abcdefABCDEF1234", false),
      ("abcdefABCDEFabcde", false),
      ("abcdefABCDEFABCDE", false),
    )

  forAll(passwords) { (pwd, expected) =>
    s"$pwd should be valid $expected" in {
      passwordValidator.isValid(pwd) shouldBe expected
    }
  }

}
