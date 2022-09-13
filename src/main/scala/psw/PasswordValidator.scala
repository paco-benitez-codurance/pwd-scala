package psw

object PasswordValidator {
  def isValidLength(pwd: String): Boolean = pwd.length() > 8

  def hasCapitalLetter(pwd: String): Boolean =
    pwd.filter(ch => ch.toUpper == ch).length() > 0
}

class PasswordValidator(validator: String => Boolean) {
  def isValid(pwd: String): Boolean = {
    assert(pwd != null)
    validator(pwd)
  }
}
