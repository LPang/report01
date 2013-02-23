package business;

import java.util.List;

import domain.Fault;

public interface FaultManager {
	public void add(String issueid, String issuetype, String summary, String detail, String expresult, String actresult, String projectname, String foundrelease, String state, String status, String severity, String reproducibility, String reproterid, String reprotername, String assignstate);//增加用户方法

	public void edit(String issueid, String issuetype, String summary, String detail, String expresult, String actresult, String projectname, String foundrelease, String state, String status, String severity, String reproducibility, String reproterid, String reprotername);//编辑用户方法
	public void editAssigndev(String issueid, String developerid,String administratorid, String assignstate);
	public void delete(String issueid);
	public void deleteassign(String issueid);//delete a fault assign
	public List<Fault> list();
	
	public List<Fault> listsim();
	public List<Fault> listsimassign();
	public List<Fault> listassignInfo();
	public List<Fault> listassignissue(String assignerid);
	public List<Fault> listassigner(String assignerid);
	public Fault getFault(String id);
	public boolean checkfault(String id);
	public void issueAssignToDeve(String issueid, String developerid, String administratorid ,String assignstate);
}
