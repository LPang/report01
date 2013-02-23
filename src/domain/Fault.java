package domain;

public class Fault {
	private String issueid;
	private String issuetype;
	private String summary;
	private String detail;
	private String expresult;
	private String actresult;
	private String projectname;
	private String foundrelease;
	private String state;
	private String rationalstatus;
	private String severity;
	private String reproducibility;
	private int reproterid;
	private String reprotername;
	private String developerid;
	private String administratorid;
	private String assignstate;
	
	
	public String getid() {
		return issueid;
	}	
	
	public void setid(String issueid) {
		this.issueid=issueid;
	}
	
	public String gettype() {
		return issuetype;
	}
	
	public void settype(String issuetype) {
		this.issuetype=issuetype;
	}
	
	public String getsummary() {
		return summary;
	}
	
	public void setsummary(String summary) {
		this.summary=summary;
	}
	
	public String getdetail() {
		return detail;
	}
	
	public void setdeatil(String detail) {
		this.detail=detail;
	}
	
	public String getexpresult() {
		return expresult;
	}
	
	public void setexpresult(String expresult) {
		this.expresult=expresult;
	}
	
	public String getactresult() {
		return actresult;
	}
	
	public void setactresult(String actresult) {
		this.actresult=actresult;
	}
	
	public String getproname() {
		return projectname;
	}
	
	public void setproname(String projectname) {
		this.projectname=projectname;
	}
	
	public String getrelease() {
		return foundrelease;
	}
	
	public void setrelease(String release) {
		this.foundrelease=release;
	}
	
	public String getstate() {
		return state;
	}
	
	public void setstate(String state) {
		this.state=state;
	}
	
	public String getstatus() {
		return rationalstatus;
	}
	
	public void setstatus(String rationalstatus) {
		this.rationalstatus=rationalstatus;
	}
	public String getseverity() {
		return severity;
	}
	
	public void setseverity(String severity) {
		this.severity=severity;
	}
	
	public String getrepro() {
		return reproducibility;
	}
	
	public void setreproducty(String reproduc) {
		this.reproducibility=reproduc;
	}
	
	public int getreporterid() {
		return reproterid;
	}
	
	public void setreporterid(int reporterid) {
		this.reproterid=reporterid;
	}
	
	public String getreportername() {
		return reprotername;
	}
	
	public void setreportername(String reportername) {
		this.reprotername=reportername;
	}
	
	public String getdeveloperid(){
		return developerid;
	}
	
	public void setdeveloperid(String developerid){
		this.developerid=developerid;
	}
	
	public String getadministratorid() {
		return administratorid;
	}
	
	public void setadministrator(String administratorid) {
		this.administratorid=administratorid;
	}
	
	public String getassignstate() {
		return assignstate;
	}
	
	public void setassignstate(String assignstate) {
		this.assignstate=assignstate;
	}
}

