import std.conv;
import std.stdio;

import participants.participants;
import participants.date;

void main()
{
    string input, buf;
    while ((buf = readln()) !is null)
        input ~= buf;
    auto participants = new Participants(to!string(input));
    writeln(participants.onDate(new Date(2013, 10, 9)));
}
