package cn.chenhuanran.app.bean;

public class BreakFast {
	private int _id;
	private String meal;
	private String way;
	private String time;
	public BreakFast() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BreakFast(int _id, String meal, String way, String time) {
		super();
		this._id = _id;
		this.meal = meal;
		this.way = way;
		this.time = time;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
