module participants.parser;

import std.conv;
import std.ascii;
import participants.date;

/*
  Syntax:

  S     = . / YEAR _ MONTH _ DAY _ KATA_TITLE / PARTICIPANT_NAME
  YEAR  = digit digit
  MONTH = digit digit
  DAY   = digit digit
  KATA_TITLE = [ alpha num _ ] *
  PARTICIPANT_NAME = [ alpha num _ ] *
 */

class ParseException : Exception
{
    this(string message)
    {
        super(message);
    }
}

class Parser
{
private:

    Date date;
    string kataTitle;
    string name;

    static void readDotSlash(char ** ptr)
    {
        char * str = *ptr;
        if (str[0] == '.' && str[1] == '/')
            *ptr += 2;
        else
            throw new ParseException(to!string(str) ~ " does not start with ./");
    }

    unittest
    {
        char * arr = &("./x".dup[0]);
        readDotSlash(&arr);
        assert(*arr == 'x');
    }

    static void readChar(char ** ptr, char expected)
    {
        char * str = *ptr;
        if (str[0] == expected)
            *ptr += 1;
        else
            throw new ParseException(to!string(str) ~ " does not start with " ~ expected);
    }

    static int read2digits(char ** ptr)
    {
        char * str = *ptr;
        if (isDigit(str[0]) && isDigit(str[1])) {
            int value = (str[0] - '0') * 10 + str[1] - '0';
            *ptr += 2;
            return value;
        } else {
            throw new ParseException(to!string(str) ~ " does not start with digit digit");
        }
    }

    unittest
    {
        char * arr = &("1024".dup[0]);
        assert(read2digits(&arr) == 10);
        assert(*arr == '2');
    }

    unittest
    {
        char * arr = &("x024".dup[0]);
        bool caught = false;
        try {
            read2digits(&arr);
        } catch (ParseException e) {
            caught = true;
        }
        assert(caught);
    }

    static bool isNameChar(char c)
    {
        return isAlpha(c) || isDigit(c) || c == '_';
    }

    static string readName(char ** ptr)
    {
        string name = "";
        while (isNameChar(**ptr)) {
            name ~= **ptr;
            (*ptr)++;
        }
        if (name == "")
            throw new ParseException(to!string(*ptr) ~ " does not start with a name character");
        return name;
    }

    unittest
    {
        char * arr = &("tomy_kaira2013/".dup[0]);
        assert (readName(&arr) == "tomy_kaira2013");
        assert(*arr == '/');
    }

public:

    const string line;

    this(in string line)
    {
        this.line = line;
    }

    void parse()
    {
        char *str = &(line.dup[0]);
        readDotSlash(&str);
        int year = read2digits(&str) + 2000;
        readChar(&str, '_');
        int month = read2digits(&str);
        readChar(&str, '_');
        int day = read2digits(&str);
        readChar(&str, '_');

        this.date = new Date(year, month, day);

        this.kataTitle = readName(&str);
        readChar(&str, '/');
        this.name = readName(&str);
    }

    pure Date getDate()
    {
        return date;
    }

    pure string getKataTitle()
    {
        return kataTitle;
    }

    pure string getName()
    {
        return name;
    }
}
