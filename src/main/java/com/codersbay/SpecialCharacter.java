package com.codersbay;

public enum SpecialCharacter {
    SPACE(' '),
    EXCLAMATION('!'),
    DOUBLE_QUOTE('\"'),
    HASH('#'),
    DOLLAR_SIGN('$'),
    PERCENT('%'),
    AMPERSAND('&'),
    SINGLE_QUOTE1('\''),
    SINGLE_QUOTE2('`'),
    LEFT_PARENTHESIS('('),
    RIGHT_PARENTHESIS(')'),
    ASTERISK('*'),
    PLUS('+'),
    COMMA(','),
    MINUS('-'),
    SLASH('/'),
    COLON(':'),
    SEMICOLON(';'),
    LESS_THAN('<'),
    EQUAL_SIGN('='),
    GREATER_THAN('>'),
    QUESTION_MARK('?'),
    LEFT_BRACKET('['),
    BACKSLASH('\\'),
    RIGHT_BRACKET(']'),
    CARET('^'),
    //    UNDERSCORE("_"),
    BACKTICK('`'),
    LEFT_BRACE('{'),
    VERTICAL_BAR('|'),
    RIGHT_BRACE('}'),
    TILDE('~');

    private char specialCharacter;

    SpecialCharacter(char specialCharacter) {
        this.specialCharacter = specialCharacter;
    }

    public char getSpecialCharacter() {
        return specialCharacter;
    }

    @Override
    public String toString() {
        return "Special Character{" +
                "Special Character='" + specialCharacter + '\'' +
                '}';
    }
}
