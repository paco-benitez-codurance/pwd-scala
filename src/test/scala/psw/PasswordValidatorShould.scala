package psw

import org.scalatest.flatspec._
import org.scalatest.matchers.should._
import org.scalatest.BeforeAndAfterEach
import org.scalatest.freespec.AnyFreeSpec

class PasswordValidatorShould
    extends AnyFreeSpec
    with Matchers
    with BeforeAndAfterEach {

  var passwordValidator: PasswordValidator = PasswordValidator()

  override def beforeEach(): Unit = {
    passwordValidator = PasswordValidator()
  }

  "General" - {
    "Not null argument" in {
      an[AssertionError] should be thrownBy passwordValidator.isValid(null)
    }
  }

  "Length" - {
    "should be invalid if less than 8 characters" in {
      passwordValidator.isValid("1234") shouldBe false
    }

    "should be valid if more than 8 characters" in {
      passwordValidator.isValid("012346789") shouldBe true
    }
  }

  "Capital Letter" - {
    "should be invalid if does not contain at least a capital letter" in {
      passwordValidator.isValid("abcdefghi") shouldBe false
    }

    "should be valid if contains at least a capital letter" in {
      passwordValidator.isValid("abcdefghI") shouldBe true
    }
  }

}
