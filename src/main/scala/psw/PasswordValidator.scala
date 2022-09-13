package psw

object PasswordValidator {
  def isValidLength(minLength: Int)(pwd: String): Boolean = {
    pwd.length() > minLength
  }

  def hasCapitalLetter = hasSomeLetter(_.isUpper)

  def hasLowerCaseLetter = hasSomeLetter(_.isLower)

  def hasNumber = hasSomeLetter(_.isDigit)

  def hasUnderscore = hasSomeLetter(_ == '_')

  type predicate = String => Boolean

  def compose(func: predicate*): String => Boolean = { str =>
    func.foldLeft(true)((res, b) => res && b(str))
  }

  private def hasSomeLetter(validate: Char => Boolean)(str: String): Boolean = {
    str.filter(validate).length() > 0
  }

  def validationOne = compose(
    isValidLength(8),
    hasCapitalLetter,
    hasLowerCaseLetter,
    hasNumber,
    hasUnderscore
  )

  def validationTwo = compose(
    isValidLength(6),
    hasCapitalLetter,
    hasLowerCaseLetter,
    hasNumber
  )

  def validationThree = compose(
    isValidLength(16),
    hasCapitalLetter,
    hasLowerCaseLetter,
    hasNumber
  )
}

class PasswordValidator(validator: String => Boolean) {
  def isValid(pwd: String): Boolean = {
    assert(pwd != null)
    validator(pwd)
  }
}
