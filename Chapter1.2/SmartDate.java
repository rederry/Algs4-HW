
public class SmartDate {
    private final int month;
    private final int day;
    private final int year;
    
    public SmartDate(int m, int d, int y) {
        validate(m, d, y);
        month = m;
        day = d;
        year = y;
    }
    
    public SmartDate(String date) {
        String[] fields = date.split("/");
        if (fields.length != 3) throw new IllegalArgumentException();
        int m = Integer.parseInt(fields[0]);
        int d = Integer.parseInt(fields[1]);
        int y = Integer.parseInt(fields[2]);
        validate(m, d, y);
        month = m;
        day = d;
        year = y;
    }
    
    private void validate(int m, int d, int y) {
        if (y < 1 || m < 1 || m > 12 || d < 1 || d > getMaxDayInMonth(m, y))
            throw new IllegalArgumentException();
    }
    
    private boolean isLeapYear(int y) {
        return y % 400 == 0 || y % 4 == 0 && y % 100 != 0;
    }
    
    private int getMaxDayInMonth(int m, int y) {
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 12:                
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(y) ? 29 : 28;
            default:
                return -1;
        }
    }
    
    private int getAllDays(int y) {
        return isLeapYear(y)? 366 : 365;
    }
    
    private int getDays(int m, int y, int d) {
        int sum = 0;
        for (int i = 1; i < m; i++) {
            sum += getMaxDayInMonth(i, y);
        }
        return sum + d;
    }
    
    public String dayOfTheWeek() {
        int daysFrom2000 = -1;
        for (int y = 2000; y < year; y++)
            daysFrom2000 += getAllDays(y);
        daysFrom2000 += getDays(month, year, day);
        int d = daysFrom2000 % 7;
        switch (d) {
            case 0: return "Saturday";
            case 1: return "Sunday";
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5: return "Thursday";
            default: return "Friday";
        }
    }
    
    public int month() { return month; }
    public int day() { return day; }
    public int year() { return year; }
    public String toString() {
        return month() + "/" + day() + "/" + year();
    }
    
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null) return false;
        if (this.getClass() != that.getClass()) return false;
        SmartDate thatSmartDate = (SmartDate) that;
        if (this.day != thatSmartDate.day) return false;
        if (this.month != thatSmartDate.month) return false;
        if (this.year != thatSmartDate.year) return false;
        return true;
    }
    
    public static void main(String[] args) {
//        SmartDate date = new SmartDate(Integer.parseInt(args[0]),
//                                       Integer.parseInt(args[1]),
//                                       Integer.parseInt(args[2]));
        SmartDate date = new SmartDate(args[0]);
        System.out.println(date.dayOfTheWeek());
    }
}