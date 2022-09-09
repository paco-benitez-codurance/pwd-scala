package psw

import org.scalatest.flatspec.AnyFlatSpec

import org.scalatest.flatspec._
import org.scalatest.matchers.should._


class PasswordValidatorShould extends AnyFlatSpec with Matchers {

  "Password Validator " should "be longer than 8 charcters" in {
    val passwordValidator = PasswordValidator()
    passwordValidator.isValid("1234") shouldBe false
  }
}
