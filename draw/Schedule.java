package draw;

import java.util.Calendar;
import java.util.Date;

/**
 * Sucheduleクラスは「日程」を表します。
 * このクラスのインスタンスは年、月、日、今日の日付、イベント一日目、予選終了予定日、インターバル予定日、本戦終了予定日、1970年1月1日からそれぞれの日付までの時間をその属性として持っています。
 * インスタンスを操作するメソッドを提供します。
 * @author C0119054
 *
 */
public class Schedule {
	/** 年*/
	private int year;
	/** 月*/
	private int month;
	/** 日*/
	private int day;
	/** 今日の日付*/
	private Date today;
	/** イベント一日目の日付*/
	private Date day1;
	/** 予選終了予定日の日付*/
	private Date preliminary;
	/** インターバル予定日の日付*/
	private Date interval;
	/** 本戦終了予定日の日付*/
	private Date mainbattle;
	/** 1970年1月1日から今日の日付までの時間*/
	private long todaydiffer;
	/** 1970年1月1日からイベント一日目の日付までの時間*/
	private long day1differ;
	/** 1970年1月1日から予選終了予定日の日付までの時間*/
	private long prediffer;
	/** 1970年1月1日からインターバル予定日の日付までの時間*/
	private long interdiffer;
	/** 1970年1月1日から本戦終了予定日の日付までの時間*/
	private long mbdiffer;

	/**
	 * 日程のインスタンスを生成します。
	 * ただし、年月日の設定は行いません。
	 * 使わないでください。
	 * @deprecated
	 */
	public Schedule() {

	}

	/**
	 * 年月日を持つ日程のインスタンスを生成します。
	 * CalendarクラスのgetInstance()で今日の日付を取得、生成します。
	 * 引数から取得した日付をイベント一日目に設定し、各日付と1970年1月1日までの時間を生成します。
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 */
	public Schedule(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.today = new Date();
		this.day1 = new Date();
		this.preliminary = new Date();
		this.interval = new Date();
		this.mainbattle = new Date();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		this.today = cal.getTime();
		this.todaydiffer = cal.getTimeInMillis();
		cal.clear();
		cal.set(year, month - 1, day);
		this.day1 = cal.getTime();
		this.day1differ = cal.getTimeInMillis();
		cal.clear();
		cal.set(year, month - 1, day + 1);
		preliminary = cal.getTime();
		this.prediffer = cal.getTimeInMillis();
		cal.clear();
		cal.set(year, month - 1, day + 2);
		this.interval = cal.getTime();
		this.interdiffer = cal.getTimeInMillis();
		cal.clear();
		cal.set(year, month - 1, day + 6);
		this.mainbattle = cal.getTime();
		this.mbdiffer = cal.getTimeInMillis();
	}

	/**
	 * このインスタンスが持つ年を返します。
	 * @return 年
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * このインスタンスの年を変更します。
	 * @param year 年
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * このインスタンスが持つ月を返します。
	 * @return 月
	 */
	public int getMonth() {
		return this.month;
	}

	/**
	 * このインスタンスの月を変更します。
	 * @param month 月
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * このインスタンスが持つ日を返します。
	 * @return day 日
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * このインスタンスの日を変更します。
	 * @param day 日
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * このインスタンスが持つ今日の日付を返します。
	 * @return 今日の日付
	 */
	public Date getToday() {
		return this.today;
	}

	/**
	 * このインスタンスの今日の日付を変更します。
	 * @param today 今日の日付
	 */
	public void setToday(Date today) {
		this.today = today;
	}

	/**
	 * このインスタンスが持つイベント一日目を返します。
	 * @return イベント一日目
	 */
	public Date getDay1() {
		return this.day1;
	}

	/**
	 * このインスタンスのイベント一日目を変更します。
	 * @param day1 イベント一日目
	 */
	public void setDay1(Date day1) {
		this.day1 = day1;
	}

	/**
	 * このインスタンスが持つ予選終了予定日を返します。
	 * @return 予選終了予定日
	 */
	public Date getPreliminary() {
		return this.preliminary;
	}

	/**
	 * このインスタンスの予選終了予定日を変更します。
	 * @param preliminary 予選終了予定日
	 */
	public void setPreliminary(Date preliminary) {
		this.preliminary = preliminary;
	}

	/**
	 * このインスタンスが持つインターバル予定日を返します。
	 * @return インターバル予定日
	 */
	public Date getInterval() {
		return this.interval;
	}

	/**
	 * このインスタンスのインターバル予定日を変更します。
	 * @param interval インターバル予定日
	 */
	public void setInterval(Date interval) {
		this.interval = interval;
	}

	/**
	 * このインスタンスが持つ本戦終了予定日を返します。
	 * @return 本戦終了予定日
	 */
	public Date getMainbattle() {
		return this.mainbattle;
	}

	/**
	 * このインスタンスの本戦終了予定日を変更します。
	 * @param mainbattle 本戦終了予定日
	 */
	public void setMainbattle(Date mainbattle) {
		this.mainbattle = mainbattle;
	}

	/**
	 * このインスタンスが持つ1970年1月1日から今日の日付までの時間を返します。
	 * @return 1970年1月1日から今日の日付までの時間
	 */
	public long getTodaydiffer() {
		return this.todaydiffer;
	}

	/**
	 * このインスタンスの1970年1月1日から今日の日付までの時間を変更します。
	 * @param todaydiffer 1970年1月1日から今日の日付までの時間
	 */
	public void setTodaydiffer(long todaydiffer) {
		this.todaydiffer = todaydiffer;
	}

	/**
	 * このインスタンスが持つ1970年1月1日からイベント一日目までの時間を返します。
	 * @return 1970年1月1日からイベント一日目のまでの時間
	 */
	public long getDay1differ() {
		return this.day1differ;
	}

	/**
	 * このインスタンスの1970年1月1日からイベント一日目までの時間を変更します。
	 * @param day1differ 1970年1月1日からイベント一日目のまでの時間
	 */
	public void setDay1differ(long day1differ) {
		this.day1differ = day1differ;
	}

	/**
	 * このインスタンスが持つ1970年1月1日から予選終了予定日までの時間を返します。
	 * @return 1970年1月1日から予選終了予定日のまでの時間
	 */
	public long getPrediffer() {
		return this.prediffer;
	}

	/**
	 * このインスタンスの1970年1月1日から予選終了予定日までの時間を変更します。
	 * @param prediffer 1970年1月1日から予選終了予定日のまでの時間
	 */
	public void setPrediffer(long prediffer) {
		this.prediffer = prediffer;
	}

	/**
	 * このインスタンスが持つ1970年1月1日からインターバル予定日までの時間を返します。
	 * @return 1970年1月1日からインターバル予定日のまでの時間
	 */
	public long getInterdiffer() {
		return this.interdiffer;
	}

	/**
	 * このインスタンスの1970年1月1日からインターバル予定日までの時間を変更します。
	 * @param interdiffer 1970年1月1日からインターバル予定日のまでの時間
	 */
	public void setInterdiffer(long interdiffer) {
		this.interdiffer = interdiffer;
	}

	/**
	 * このインスタンスが持つ1970年1月1日から本戦終了予定日までの時間を返します。
	 * @return 1970年1月1日から本戦終了予定日のまでの時間
	 */
	public long getMBdiffer() {
		return this.mbdiffer;
	}

	/**
	 * このインスタンスの1970年1月1日から本戦終了予定日までの時間を変更します。
	 * @param mbdiffer 1970年1月1日から本戦終了予定日のまでの時間
	 */
	public void setMaindiffer(long mbdiffer) {
		this.mbdiffer = mbdiffer;
	}

}