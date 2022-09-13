package psw

object PasswordValidator {
  def isValidLength(pwd: String): Boolean = pwd.length() > 8

  def hasCapitalLetter = hasSomeLetter(_.isUpper)

  def hasLowerCaseLetter = hasSomeLetter(_.isLower)

  def hasNumber = hasSomeLetter(_.isDigit)

  def hasUnderscore = hasSomeLetter(_ == '_')

  type predicate = String => Boolean

  def compose(func: predicate *): String => Boolean =  {
    str => func.foldLeft(true)((res, b) => res && b(str))
  }

  private def hasSomeLetter(validate: Char => Boolean)(str: String): Boolean = {
    str.filter(validate).length() > 0
  }

  def iterationOne = compose(isValidLength, hasCapitalLetter, hasNumber, hasUnderscore)
}

class PasswordValidator(validator: String => Boolean) {
  def isValid(pwd: String): Boolean = {
    assert(pwd != null)
    validator(pwd)
  }
}
