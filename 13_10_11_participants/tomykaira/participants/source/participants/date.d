module participants.date;

class Date
{
public:
    const int year, month, day;

    // associative array misbehaves without hash, equal, and cmp
    override hash_t toHash()
    {
        return day + (month + year * 12) * 31;
    }

    override bool opEquals(Object o)
    {
        Date date = cast(Date) o;
        return date && year == date.year && month == date.month && day == date.day;
    }

    override int opCmp(Object o)
    {
        Date other = cast(Date) o;
        if (!other)
            return - 1;
        if (year != other.year)
            return year - other.year;
        else if (month != other.month)
            return month - other.month;
        return day - other.day;
    }

    this(in uint year, in uint month, in uint day)
    in
        {
            assert(1 <= month && month <= 12);
            assert(1 <= day);
            int lastDay;
            switch (month) {
            case 2:
                lastDay = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                lastDay = 30;
                break;
            default:
                lastDay = 31;
                break;
            }
            assert(day <= lastDay);
        }
    body
        {
            this.year = year;
            this.month = month;
            this.day = day;
        }
}
