package massRetrieval;

import java.net.*;
import com.bullhornsdk.data.api.BullhornData;
import com.bullhornsdk.data.api.BullhornRestCredentials;
import com.bullhornsdk.data.api.StandardBullhornData;
import com.bullhornsdk.data.exception.RestApiException;
import com.bullhornsdk.data.model.entity.core.standard.Appointment;
import com.bullhornsdk.data.model.entity.core.standard.Candidate;
import com.bullhornsdk.data.model.entity.core.standard.ClientContact;
import com.bullhornsdk.data.model.entity.core.standard.JobOrder;
import com.bullhornsdk.data.model.entity.core.standard.JobSubmission;
import com.bullhornsdk.data.model.entity.core.standard.Lead;
import com.bullhornsdk.data.model.entity.core.standard.Note;
import com.bullhornsdk.data.model.entity.core.standard.NoteEntity;
import com.bullhornsdk.data.model.entity.core.standard.Opportunity;
import com.bullhornsdk.data.model.entity.core.standard.Task;
import com.bullhornsdk.data.model.entity.core.standard.Tearsheet;
import com.bullhornsdk.data.model.parameter.QueryParams;
import com.bullhornsdk.data.model.parameter.SearchParams;
import com.bullhornsdk.data.model.parameter.standard.ParamFactory;
import com.bullhornsdk.data.model.response.list.OpportunityListWrapper;
import com.bullhornsdk.data.model.response.list.TaskListWrapper;
import com.bullhornsdk.data.model.response.list.TearsheetListWrapper;
import com.bullhornsdk.data.model.response.list.AppointmentListWrapper;
import com.bullhornsdk.data.model.response.list.CandidateListWrapper;
import com.bullhornsdk.data.model.response.list.ClientContactListWrapper;
import com.bullhornsdk.data.model.response.list.JobOrderListWrapper;
import com.bullhornsdk.data.model.response.list.JobSubmissionListWrapper;
import com.bullhornsdk.data.model.response.list.LeadListWrapper;
import com.bullhornsdk.data.model.response.list.NoteEntityListWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Retrieval {
	
	private SearchParams searchparams = ParamFactory.searchParams();
	private QueryParams params = ParamFactory.queryParams();
	private Set<String> fields = Sets.newHashSet("id");
	private ObjectMapper mapper = new ObjectMapper();
	private Pattern p = Pattern.compile("id(\"\\:)(.*?)(\\})");
	private Matcher m;
	private JPanel pnl;
	
	protected Retrieval (String restUrl, String bhRestToken, String entity, String criteria) throws 
	MalformedURLException, JsonProcessingException{
		init(restUrl, bhRestToken, entity, criteria);
	}
	
	private void init(String restUrl, String bhRestToken, String entity, String criteria) throws 
		JsonProcessingException, RestApiException{
		
		searchparams.setCount(500);
		params.setCount(500);
		String query = "isDeleted:1 AND " + criteria;
		String query2 = "isDeleted=true AND " + criteria;
		BullhornRestCredentials creds = new BullhornRestCredentials();
		creds.setBhRestToken(bhRestToken);
		creds.setRestUrl(restUrl);
		BullhornData rest = new StandardBullhornData(creds);
		ImageIcon msgicon = new ImageIcon("bullicon.png");
		int start = 0;
		try{
		switch(entity){
		
		case "Candidate":{
			
			Candidate candidate = new Candidate();
			CandidateListWrapper candidateList;
			ArrayList<Candidate> list = new ArrayList<Candidate>();
			
			do{
			searchparams.setStart(start);
			candidateList = (CandidateListWrapper) rest.search(candidate.getClass(), 
					query, fields, searchparams);
			
			if(candidateList.getCount()!=0){
				Matcher m = p.matcher(mapper.writeValueAsString(candidateList.getData()));
				
				while(m.find()){
					int id = Integer.parseInt(m.group(2));
					
					candidate = new Candidate(id);
					candidate.setIsDeleted(false);
					list.add(candidate);
					
					}
				if(candidateList.getCount()==500)
					start +=500;
				
				}}while(candidateList.getCount()==500);
			
			rest.updateMultipleEntities(list);
			
		}
		break;
case "ClientContact":{
			
			ClientContact contact = new ClientContact();
			ClientContactListWrapper contactList;
			ArrayList<ClientContact> list = new ArrayList<ClientContact>();
			
			do{
			searchparams.setStart(start);
			p = Pattern.compile("id(\"\\:)(.*?)(\\,)");
			contactList = (ClientContactListWrapper) rest.search(contact.getClass(), 
					query, fields, searchparams);
			
			if(contactList.getCount()!=0){
				Matcher m = p.matcher(mapper.writeValueAsString(contactList.getData()));
				
				while(m.find()){
					System.out.println(m.group(2));
					int id = Integer.parseInt(m.group(2));
				
					contact = new ClientContact(id);
					contact.setIsDeleted(false);
					list.add(contact);
					
					}
				if(contactList.getCount()==500)
					start +=500;
				
				}}while(contactList.getCount()==500);
			
			rest.updateMultipleEntities(list);
			
		}
		break;
		case "JobOrder":{
		
		JobOrder job = new JobOrder();
		JobOrderListWrapper jobList;
		ArrayList<JobOrder> list = new ArrayList<JobOrder>();
		
		do{
		searchparams.setStart(start);
		jobList = (JobOrderListWrapper) rest.search(job.getClass(), 
				query, fields, searchparams);
		
		if(jobList.getCount()!=0){
			Matcher m = p.matcher(mapper.writeValueAsString(jobList.getData()));
			
			while(m.find()){
				int id = Integer.parseInt(m.group(2));
			
				job = new JobOrder(id);
				job.setIsDeleted(false);
				list.add(job);
				
				}
			if(jobList.getCount()==500)
				start +=500;
			
			}}while(jobList.getCount()==500);
		
		rest.updateMultipleEntities(list);
		
		}
		break;
		case "JobSubmission":{
		
		JobSubmission submission = new JobSubmission();
		JobSubmissionListWrapper submissionList;
		ArrayList<JobSubmission> list = new ArrayList<JobSubmission>();
		
		do{
		searchparams.setStart(start);
		submissionList = (JobSubmissionListWrapper) rest.search(submission.getClass(), 
				query, fields, searchparams);
		
		if(submissionList.getCount()!=0){
			Matcher m = p.matcher(mapper.writeValueAsString(submissionList.getData()));
			
			while(m.find()){
				int id = Integer.parseInt(m.group(2));
			
				submission = new JobSubmission(id);
				submission.setIsDeleted(false);
				list.add(submission);
				
				}
			if(submissionList.getCount()==500)
				start +=500;
			
			}}while(submissionList.getCount()==500);
		
		rest.updateMultipleEntities(list);
		
		}
		break;
		case "Lead":{
			
			Lead lead = new Lead();
			LeadListWrapper leadList;
			ArrayList<Lead> list = new ArrayList<Lead>();
			
			do{
			searchparams.setStart(start);
			leadList = (LeadListWrapper) rest.search(lead.getClass(), 
					query, fields, searchparams);
			
			if(leadList.getCount()!=0){
				Matcher m = p.matcher(mapper.writeValueAsString(leadList.getData()));
				
				while(m.find()){
					int id = Integer.parseInt(m.group(2));
				
					lead = new Lead(id);
					lead.setIsDeleted(false);
					list.add(lead);
					
					}
				if(leadList.getCount()==500)
					start +=500;
				
				}}while(leadList.getCount()==500);
			
			rest.updateMultipleEntities(list);
			
		}
		break;
		case "Opportunity":{
			
			Opportunity opportunity = new Opportunity();
			OpportunityListWrapper opportunityList;
			ArrayList<Opportunity> list = new ArrayList<Opportunity>();
			
			do{
			searchparams.setStart(start);
			opportunityList = (OpportunityListWrapper) rest.search(opportunity.getClass(), 
					query, fields, searchparams);
			
			if(opportunityList.getCount()!=0){
				Matcher m = p.matcher(mapper.writeValueAsString(opportunityList.getData()));
				
				while(m.find()){
					int id = Integer.parseInt(m.group(2));
				
					opportunity = new Opportunity(id);
					opportunity.setIsDeleted(false);
					list.add(opportunity);
					
					}
				if(opportunityList.getCount()==500)
					start +=500;
				
				}}while(opportunityList.getCount()==500);
			
			rest.updateMultipleEntities(list);
			
		}
		break;
		case "Appointment":{
			
			Appointment appointment = new Appointment();
			AppointmentListWrapper appointmentList;
			ArrayList<Appointment> list = new ArrayList<Appointment>();
			
			do{
			params.setStart(start);
			appointmentList = (AppointmentListWrapper) rest.query(appointment.getClass(), 
					query2, fields, params);
			
			if(appointmentList.getCount()!=0){
				System.out.println(mapper.writeValueAsString(appointmentList.getData()));
				Matcher m = p.matcher(mapper.writeValueAsString(appointmentList.getData()));
				
				while(m.find()){
					int id = Integer.parseInt(m.group(2));
					System.out.println(id);
					appointment = new Appointment(id);
					appointment.setIsDeleted(false);
					list.add(appointment);
					
					}
				if(appointmentList.getCount()==500)
					start +=500;
				
				}}while(appointmentList.getCount()==500);
			
			rest.updateMultipleEntities(list);
			
		}
		break;
		case "Tearsheet":{
			
			Tearsheet tearsheet = new Tearsheet();
			TearsheetListWrapper tearsheetList;
			ArrayList<Tearsheet> list = new ArrayList<Tearsheet>();
			
			do{
			params.setStart(start);
			tearsheetList = (TearsheetListWrapper) rest.query(tearsheet.getClass(), 
					query2, fields, params);
			
			if(tearsheetList.getCount()!=0){
				System.out.println(mapper.writeValueAsString(tearsheetList.getData()));
				Matcher m = p.matcher(mapper.writeValueAsString(tearsheetList.getData()));
				
				while(m.find()){
					int id = Integer.parseInt(m.group(2));
					System.out.println(id);
					tearsheet = new Tearsheet(id);
					tearsheet.setIsDeleted(false);
					list.add(tearsheet);
					
					}
				if(tearsheetList.getCount()==500)
					start +=500;
				
				}}while(tearsheetList.getCount()==500);
			
			rest.updateMultipleEntities(list);
			
		}
		break;
		case "Note":{
			
			Note note = new Note();
			NoteEntity noteE = new NoteEntity();
			NoteEntityListWrapper noteList;
			ArrayList<Note> list = new ArrayList<Note>();
			
			do{
			params.setStart(start);
			noteList = (NoteEntityListWrapper) rest.query(noteE.getClass(), 
					query2, fields, params);
			
			if(noteList.getCount()!=0){
				System.out.println(mapper.writeValueAsString(noteList.getData()));
				Matcher m = p.matcher(mapper.writeValueAsString(noteList.getData()));
				
				while(m.find()){
					int id = Integer.parseInt(m.group(2));
					note = new Note(id);
					note.setIsDeleted(false);
					list.add(note);
					
					}
				if(noteList.getCount()==500)
					start +=500;
				
				}}while(noteList.getCount()==500);
			
			rest.updateMultipleEntities(list);
			
		}
		break;
		case "Task":{
			
			Task task = new Task();
			TaskListWrapper taskList;
			ArrayList<Task> list = new ArrayList<Task>();
			
			do{
			params.setStart(start);
			taskList = (TaskListWrapper) rest.query(task.getClass(), 
					query2, fields, params);
			
			if(taskList.getCount()!=0){
				System.out.println(mapper.writeValueAsString(taskList.getData()));
				Matcher m = p.matcher(mapper.writeValueAsString(taskList.getData()));
				
				while(m.find()){
					int id = Integer.parseInt(m.group(2));
					System.out.println(id);
					task = new Task(id);
					task.setIsDeleted(false);
					list.add(task);
					
					}
				if(taskList.getCount()==500)
					start +=500;
				
				}}while(taskList.getCount()==500);
			
			rest.updateMultipleEntities(list);
			
		}
		break;
		}
		JOptionPane.showMessageDialog(pnl, "Success!!", "Info", JOptionPane.INFORMATION_MESSAGE, msgicon);
	}
	catch(RestApiException e){
		StringBuilder sb = new StringBuilder(e.toString());
	    for (StackTraceElement ste : e.getStackTrace()) {
	        sb.append("\n\tat ");
	        sb.append(ste);
	    }
	    String trace = sb.toString();
	    JOptionPane.showMessageDialog(pnl, trace, "Warning", JOptionPane.ERROR_MESSAGE, msgicon);
	}
	}
}
