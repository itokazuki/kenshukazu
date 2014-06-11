package sample.entity;


public class Todo{
	String title;
	String task;
	String limitdate;
	String lastupdate;
	String userid;
	int status;




	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTask(){
		return task;
	}

	public void setTask(String task){
		this.task = task;
	}

	public String getLimitdate(){
		return limitdate;
	}

	public void setLimitdate(String Limitdate){
		this.task = limitdate;
	}

	public String getLastupdate(){
		return lastupdate;
	}

	public void setLastupdate(String lastupdate){
		this.lastupdate = lastupdate;
	}



	public String getUserid(){
		return userid;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public int getStatus(){
		return status;
	}

	public void setStatus(int status){
		this.status = status;
	}
}
