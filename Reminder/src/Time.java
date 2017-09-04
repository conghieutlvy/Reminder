package btl_oop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class Time 
 * Mo ta thoi gian va dinh dang in thoi gian
 *  @author Nhom 2
 */
public class Time {
    /** bien luu thong tin thoi gian*/
    private Date time;
    /** bien tao dinh dang(format) cho thoi gian (dung de luu thong tin vao File)*/
    private DateFormat format;
     /** bien tao dinh dang(format) cho thoi gian(dung de in thong tin)*/
    private DateFormat format1;
     /** bien tao dinh dang(format) cho thoi gian chi gom gio va phut(dung de luu thong tin vao File)*/
    private DateFormat formatHM;
     /** bien tao dinh dang(format) cho thoi gian chi gom gio va phut(dung de in thong tin)*/
    private DateFormat formatHM1;
	
     /**
     * Ham khoi tao khong tham so
     */
	@SuppressWarnings("deprecation")
	public Time() {
		/** tao dinh dang mac dinh */
		format = new SimpleDateFormat("mm HH dd MM yyyy");
                format1 = new SimpleDateFormat("mm : HH - dd / MM / yyyy");
                formatHM1 = new SimpleDateFormat("mm HH");
                formatHM = new SimpleDateFormat("mm : HH");
                time = new Date();
		
	}
	
        /**
         * Ham khoi tao co tham so
         * @param y nam
         * @param m thanh
         * @param day ngay
         * @param hour gio 
         * @param min phut
         */
	@SuppressWarnings("deprecation")
	public Time(int y,int m,int day,int hour,int min) {
		int year = y - 1900;
		int month = m-1;
		time = new Date(year,month,day,hour,min);
                /** tao dinh dang mac dinh */
		format = new SimpleDateFormat("mm HH dd MM yyyy");
                format1 = new SimpleDateFormat("mm : HH - dd / MM / yyyy");
                formatHM = new SimpleDateFormat("mm HH");
                formatHM1 = new SimpleDateFormat("mm : HH");
                
	}
        
         /**
         * Ham khoi tao co tham so ngay phut va gio
         * @param hour phut
         * @param min  gio
         * @param date ngay
         */
        public Time(int hour,int min,Date date){
            time = date;
            time.setHours(hour);
            time.setMinutes(min);
            format = new SimpleDateFormat("mm HH dd MM yyyy");
            format1 = new SimpleDateFormat("mm : HH - dd / MM / yyyy");
            formatHM = new SimpleDateFormat("mm HH");
            formatHM1 = new SimpleDateFormat("HH : mm");
        }  
        /**
         * Ham khoi tao co tham so phut va gio
         * @param hour phut
         * @param min  gio
         */
        public Time(int hour,int min){
            time = new Date(-1990, 0, 1 , hour, min);
            format = new SimpleDateFormat("mm HH dd MM yyyy");
            format1 = new SimpleDateFormat("mm : HH - dd / MM / yyyy");
            formatHM = new SimpleDateFormat("mm HH");
            formatHM1 = new SimpleDateFormat("HH : mm");
        }    
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public DateFormat getFormat() {
		return format;
	}

	public void setFormat(DateFormat format) {
		this.format = format;
	}
	
        /**
         * chuyen thoi gian thanh dang String(theo format)
         * @return 
         */
	public String toStringTime(){
		return format.format(time);
	}
        
        /**
         * chuyen thoi gian thanh dang String(dung de in)
         * @return 
         */
        public String toStringTime1(){
		return format1.format(time);
	}
        
        /**
         * chuyen thoi gian thanh dang String chi hien gio va phut (dung de in)
         * @return 
         */
        public String toStringTimeHM1(){
		return formatHM1.format(time);
	} 
        
        /**
         * chuyen thoi gian thanh dang String chi hien gio va phut (dung de luu File)
         * @return 
         */
        public String toStringTimeHM(){
		return formatHM.format(time);
	}
       
        /**
         * chuyen mot chuoi String(lay tu file) sang format Time
         * @param complex 
         */
	@SuppressWarnings("deprecation")
	public void convertToDate(String complex){
		String[] unit =  complex.split("\\s");
		//System.out.println(unit.length);
		time = new Date(Integer.parseInt(unit[4]) - 1900
					   ,Integer.parseInt(unit[3]) - 1
					   ,Integer.parseInt(unit[2])
					   ,Integer.parseInt(unit[1])
					   ,Integer.parseInt(unit[0]));
		//System.out.println(format.format(time));
		}
}
