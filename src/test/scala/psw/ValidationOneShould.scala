package psw

import org.scalatest.flatspec._
import org.scalatest.matchers.should._
import org.scalatest.BeforeAndAfterEach
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.prop.TableDrivenPropertyChecks

class ValidationOneShould
    extends AnyFreeSpec
    with Matchers
    with TableDrivenPropertyChecks {

  val passwordValidator = PasswordValidator(PasswordValidator.validationOne)

  val passwords =
    Table(
      ("password", "expected"),
      ("abcdABCD1234_", true),
      ("abcdABCD1234", false),
      ("abcdABCD_", false),
      ("ABCD1234_", false)
    )

  forAll(passwords) { (pwd, expected) =>
    s"$pwd should be valid $expected" in {
      passwordValidator.isValid(pwd) shouldBe expected
    }
  }

}
