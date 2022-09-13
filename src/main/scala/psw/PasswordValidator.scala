package psw

class PasswordValidator {
  def isValid(pwd: String): Boolean = {
    assert(pwd != null)
    pwd.length() > 8  && pwd.filter(ch => ch.toUpper == ch).length() > 0
  }
}
