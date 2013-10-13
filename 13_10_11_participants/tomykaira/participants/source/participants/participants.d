module participants.participants;

import std.string;
import participants.date;
import participants.parser;

class Participants
{
private:

    string[][Date] map;

    void insert(Date date, string name)
    {
        if ((date in map) is null) {
            map[date] = [name];
        } else {
            map[date] ~= name;
        }
    }

public:

    this(string fileList)
    {
        foreach (line; fileList.splitLines()) {
            auto p = new Parser(line);
            p.parse();
            insert(p.getDate(), p.getName());
        }
    }

    string [] onDate(Date date)
    {
        auto val = date in map;
        if (val is null)
            return [];
        else
            return *val;

    }

    string[][Date] getMap()
    {
        return map.dup;
    }
}

unittest
{
    string input = "./13_10_08_KarateChop/234furuya
./13_10_08_KarateChop/akausagi
./13_10_08_KarateChop/cohei
./13_10_08_KarateChop/joker1007
./13_10_08_KarateChop/naga41
./13_10_08_KarateChop/saturday06
./13_10_09_next_palindrome/cohei
./13_10_09_next_palindrome/joker1007";
    auto participants = new Participants(input);

    assert(participants.onDate(new Date(2013, 10, 9)) == ["cohei", "joker1007"]);
    assert(participants.getMap[new Date(2013, 10, 9)] == ["cohei", "joker1007"]);
}
