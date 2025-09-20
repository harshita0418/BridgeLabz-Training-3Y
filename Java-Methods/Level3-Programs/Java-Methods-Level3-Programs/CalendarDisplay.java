class CalendarGenerator {
    private int month;
    private int year;
    private String[] monthNames = {"January", "February", "March", "April", "May", "June",
                                  "July", "August", "September", "October", "November", "December"};
    private int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public CalendarGenerator(int month, int year) {
        this.month = month;
        this.year = year;
    }
    
    public String getMonthName() {
        return monthNames[month - 1];
    }
    
    public int getDaysInMonth() {
        if (month == 2 && isLeapYear()) {
            return 29;
        }
        return daysInMonth[month - 1];
    }
    
    public boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public int getFirstDayOfMonth() {
        int y0 = year - ((14 - month) / 12);
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7;
        return d0;
    }
    
    public void displayCalendar() {
        System.out.println(getMonthName() + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        int firstDay = getFirstDayOfMonth();
        int daysInCurrentMonth = getDaysInMonth();
        
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }
        
        for (int day = 1; day <= daysInCurrentMonth; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

public class CalendarDisplay {
    public static void main(String[] args) {
        CalendarGenerator calendar = new CalendarGenerator(7, 2005);
        calendar.displayCalendar();
    }
}
