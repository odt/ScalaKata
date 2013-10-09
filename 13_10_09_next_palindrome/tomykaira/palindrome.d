import std.conv;
import std.stdio;
import std.string;

char [] plus1ToString(char [] str, uint pos)
{
    char[] mutable = str.dup;
    str[pos] += 1;
    if (str[pos] == '9' + 1) {
        str[pos] = '0';
        if (pos > 0)
            str = plus1ToString(str, pos - 1);
        else
            str = "1" ~ str;
    }
    return str;
}

unittest {
    assert(plus1ToString("1".dup, 0) == "2");
    assert(plus1ToString("9".dup, 0) == "10");
    assert(plus1ToString("191".dup, 2) == "192");
    assert(plus1ToString("191".dup, 1) == "201");
    assert(plus1ToString("191".dup, 0) == "291");
}

char [] palindromeStr(char [] str)
{
    if (str.length == 1) {
        return str;
    } else if (str[0] >= str[$ - 1]) {
        if (str.length > 3) {
            palindromeStr(str[1..$ - 1]);
        }
        str[$ - 1] = str[0];
        return str;
    } else {
        plus1ToString(str, str.length - 2);
        str[$ - 1] = '0';
        return palindromeStr(str);
    }
}

bool isPalindrome(int input)
{
    string inStr = to!string(input);
    for (uint i = 0; i < inStr.length/2; i++) {
        if (inStr[i] != inStr[inStr.length - i - 1])
            return false;
    }
    return true;
}

unittest {
    assert(isPalindrome(1));
    assert(isPalindrome(2));
    assert(isPalindrome(9));
    assert(! isPalindrome(10));
    assert(isPalindrome(101));
    assert(! isPalindrome(102));
    assert(isPalindrome(1001));
    assert(! isPalindrome(1231));
}

int palindrome(int input)
{
    if (isPalindrome(input)) {
        input += 1;
    }
    return to!int(palindromeStr(to!string(input).dup));
}

unittest {
    assert(palindrome(1) == 2);
    assert(palindrome(2) == 3);
    assert(palindrome(11) == 22);
    assert(palindrome(808) == 818);
    assert(palindrome(98087) == 98089);
    assert(palindrome(78089) == 78187);
    assert(palindrome(2133) == 2222);
    assert(palindrome(2133) == 2222);
    assert(palindrome(19992) == 20002);
    assert(palindrome(18992) == 19091);
}

void main()
{
/*
    uint lines = to!int(readln().strip);
    while (lines > 0) {
        int q = to!int(readln().strip);
        writeln(palindrome(q));
        lines--;
    }
*/
}
