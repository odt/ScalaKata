module data_mungling.weather;

import std.conv;
import std.regex;

class WeatherFile
{
private:
    DayLine[] lines;

    DayLine [] parse(string content)
    {
        DayLine[] result;
        foreach (m; match(content, regex(r"^\s*(\d+)\s+(-?\d+)\*?\s+(-?\d+)\s+",  "gm"))) {
            result ~= new DayLine(to!int(m.captures[1]), to!int(m.captures[2]), to!int(m.captures[3]));
        }
        return result;
    }

    invariant() {
        assert(lines.length > 0);
    }

public:
    this(string content)
    {
        lines = parse(content);
    }

    DayLine dayWithMinSpread()
    {
        DayLine minLine = lines[0];
        foreach (line; lines) {
            if (minLine.spread > line.spread)
                minLine = line;
        }
        return minLine;
    }
}

unittest
{
    auto file = new WeatherFile("   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5");
    assert(file.dayWithMinSpread() == new DayLine(1, 88, 59));
}

unittest
{
    auto file = new WeatherFile("
   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5
   2  79    63    71          46.5       0.00         330  8.7 340  23  3.3  70 28 1004.5");
    assert(file.dayWithMinSpread() == new DayLine(2, 79, 63));
}

class DayLine
{
public:
    const int day, max, min, spread;

    this(int day, int max, int min)
    {
        this.day = day;
        this.max = max;
        this.min = min;
        this.spread = max - min;
    }

    override bool opEquals(Object o)
    {
        DayLine line = cast(DayLine) o;
        return line && day == line.day && max == line.max && spread == line.spread;
    }

    override string toString()
    {
        return "DayLine(" ~ to!string(day) ~ ", " ~ to!string(max) ~ ", " ~ to!string(min) ~ ")";
    }
}

unittest
{
    auto line = new DayLine(15, 30, -15);
    assert(line.spread == 45);
}
