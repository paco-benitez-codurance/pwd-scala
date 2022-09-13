package psw

import org.scalatest.flatspec._
import org.scalatest.matchers.should._
import org.scalatest.BeforeAndAfterEach
import org.scalatest.freespec.AnyFreeSpec

class PasswordValidatorShould
    extends AnyFreeSpec
    with Matchers
    with BeforeAndAfterEach {

  override def beforeEach(): Unit = {}

  "General" - {
    val passwordValidator: PasswordValidator = PasswordValidator(_ => true)
    "Not null argument" in {
      an[AssertionError] should be thrownBy passwordValidator.isValid(null)
    }
  }

  "Length" - {
    val passwordValidator: PasswordValidator =
      PasswordValidator(PasswordValidator.isValidLength)
    "should be invalid if less than 8 characters" in {
      passwordValidator.isValid("1234") shouldBe false
    }

    "should be valid if more than 8 characters" in {
      passwordValidator.isValid("012346789") shouldBe true
    }
  }

  "Capital Letter" - {
    val passwordValidator: PasswordValidator =
      PasswordValidator(PasswordValidator.hasCapitalLetter)
    "should be invalid if does not contain at least a capital letter" in {
      passwordValidator.isValid("a") shouldBe false
    }

    "should be valid if contains at least a capital letter" in {
      passwordValidator.isValid("A") shouldBe true
    }
  }

}
