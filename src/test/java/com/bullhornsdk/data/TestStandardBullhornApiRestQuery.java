package com.bullhornsdk.data;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.bullhornsdk.data.model.entity.core.standard.Appointment;
import com.bullhornsdk.data.model.entity.core.standard.AppointmentAttendee;
import com.bullhornsdk.data.model.entity.core.standard.BusinessSector;
import com.bullhornsdk.data.model.entity.core.standard.CandidateCertification;
import com.bullhornsdk.data.model.entity.core.standard.CandidateEducation;
import com.bullhornsdk.data.model.entity.core.standard.CandidateReference;
import com.bullhornsdk.data.model.entity.core.standard.CandidateWorkHistory;
import com.bullhornsdk.data.model.entity.core.standard.Category;
import com.bullhornsdk.data.model.entity.core.standard.Certification;
import com.bullhornsdk.data.model.entity.core.standard.ClientContact;
import com.bullhornsdk.data.model.entity.core.standard.ClientCorporation;
import com.bullhornsdk.data.model.entity.core.standard.CorporateUser;
import com.bullhornsdk.data.model.entity.core.standard.CorporationDepartment;
import com.bullhornsdk.data.model.entity.core.standard.Country;
import com.bullhornsdk.data.model.entity.core.standard.DistributionList;
import com.bullhornsdk.data.model.entity.core.standard.File;
import com.bullhornsdk.data.model.entity.core.standard.HousingComplex;
import com.bullhornsdk.data.model.entity.core.standard.JobBoardPost;
import com.bullhornsdk.data.model.entity.core.standard.JobOrder;
import com.bullhornsdk.data.model.entity.core.standard.JobSubmission;
import com.bullhornsdk.data.model.entity.core.standard.JobSubmissionHistory;
import com.bullhornsdk.data.model.entity.core.standard.Lead;
import com.bullhornsdk.data.model.entity.core.standard.NoteEntity;
import com.bullhornsdk.data.model.entity.core.standard.Opportunity;
import com.bullhornsdk.data.model.entity.core.standard.Placement;
import com.bullhornsdk.data.model.entity.core.standard.PlacementCertification;
import com.bullhornsdk.data.model.entity.core.standard.PlacementChangeRequest;
import com.bullhornsdk.data.model.entity.core.standard.PlacementCommission;
import com.bullhornsdk.data.model.entity.core.standard.Sendout;
import com.bullhornsdk.data.model.entity.core.standard.Skill;
import com.bullhornsdk.data.model.entity.core.standard.Specialty;
import com.bullhornsdk.data.model.entity.core.standard.State;
import com.bullhornsdk.data.model.entity.core.standard.Task;
import com.bullhornsdk.data.model.entity.core.standard.TimeUnit;
import com.bullhornsdk.data.model.entity.core.standard.WorkersCompensation;
import com.bullhornsdk.data.model.entity.core.standard.WorkersCompensationRate;
import com.bullhornsdk.data.model.entity.core.type.BullhornEntity;
import com.bullhornsdk.data.model.entity.embedded.UserType;
import com.bullhornsdk.data.model.parameter.QueryParams;
import com.bullhornsdk.data.model.parameter.standard.ParamFactory;
import com.bullhornsdk.data.model.response.list.ListWrapper;

/**
 * Tests the "query" request
 * 
 * @author magnus.palm
 * 
 */

public class TestStandardBullhornApiRestQuery extends BaseTest {
	private final Logger log = Logger.getLogger(TestStandardBullhornApiRestQuery.class);

	private String where = "id>0";

	private QueryParams queryParams;

	public TestStandardBullhornApiRestQuery() {
		super();
		this.queryParams = ParamFactory.queryParams();

	}

	@Test
	public void testQueryAppointment() {

		ListWrapper<Appointment> wrapper = bullhornData.query(Appointment.class, where, null, queryParams);

		runAssertions("ListWrapper<Appointment>", wrapper);
	}

	@Test
	public void testQueryAppointmentAttendee() {

		ListWrapper<AppointmentAttendee> wrapper = bullhornData.query(AppointmentAttendee.class, where, null, queryParams);

		runAssertions("ListWrapper<AppointmentAttendee>", wrapper);

	}

	@Test
	public void testQueryBusinessSector() {

		ListWrapper<BusinessSector> wrapper = bullhornData.query(BusinessSector.class, where, null, queryParams);

		runAssertions("ListWrapper<BusinessSector>", wrapper);
	}

    @Test
    public void testQueryCandidateCertification() {

        ListWrapper<CandidateCertification> wrapper = bullhornData.query(CandidateCertification.class, where, null, queryParams);

        runAssertions("ListWrapper<CandidateCertification>", wrapper);

    }

	@Test
	public void testQueryCandidateEducation() {

		ListWrapper<CandidateEducation> wrapper = bullhornData.query(CandidateEducation.class, where, null, queryParams);

		runAssertions("ListWrapper<CandidateEducation>", wrapper);

	}

	@Test
	public void testQueryCandidateReference() {

		ListWrapper<CandidateReference> wrapper = bullhornData.query(CandidateReference.class, where, null, queryParams);

		runAssertions("ListWrapper<CandidateEducation>", wrapper);

	}

	@Test
	public void testQueryCandidateWorkHistory() {

		ListWrapper<CandidateWorkHistory> wrapper = bullhornData.query(CandidateWorkHistory.class, where, null, queryParams);

		runAssertions("ListWrapper<CandidateWorkHistory>", wrapper);
	}

	@Test
	public void testQueryCategory() {

		ListWrapper<Category> wrapper = bullhornData.query(Category.class, where, null, queryParams);

		runAssertions("ListWrapper<Category>", wrapper);

	}

	@Test
	public void testQueryCertification() {

		ListWrapper<Certification> wrapper = bullhornData.query(Certification.class, where, null, queryParams);

		runAssertions("ListWrapper<Certification>", wrapper);

	}

	@Test
	public void testQueryClientContact() {

		ListWrapper<ClientContact> wrapper = bullhornData.query(ClientContact.class, where, null, queryParams);

		runAssertions("ListWrapper<ClientContact>", wrapper);

	}

	@Test
	public void testQueryClientCorporation() {

		ListWrapper<ClientCorporation> wrapper = bullhornData.query(ClientCorporation.class, where, null, queryParams);

		runAssertions("ListWrapper<ClientCorporation>", wrapper);

	}

	@Test
	public void testQueryCorporateUser() {

		String where = "isDeleted=true";
		ListWrapper<CorporateUser> wrapper = bullhornData.query(CorporateUser.class, where, null, queryParams);
		assertTrue(wrapper.getCount() == 1);
		runAssertions("ListWrapper<CorporateUser>", wrapper);

	}

	@Test
	public void testQueryCorporationDepartment() {

		ListWrapper<CorporationDepartment> wrapper = bullhornData.query(CorporationDepartment.class, where, null, queryParams);

		runAssertions("ListWrapper<CorporationDepartment>", wrapper);

	}

	@Test
	public void testQueryCountry() {

		ListWrapper<Country> wrapper = bullhornData.query(Country.class, where, null, queryParams);

		runAssertions("ListWrapper<Country>", wrapper);

	}

    @Test
    public void testQueryDistributionList() {

        ListWrapper<DistributionList> wrapper = bullhornData.query(DistributionList.class, where, null, queryParams);

        runAssertions("ListWrapper<DistributionList>", wrapper);

    }

    @Test
    public void testQueryWorkersCompensation() {

        ListWrapper<WorkersCompensation> wrapper = bullhornData.query(WorkersCompensation.class, where, null, queryParams);

        runAssertions("ListWrapper<WorkersCompensation>", wrapper);

    }

    @Test
    public void testQueryWorkersCompensationRate() {

        ListWrapper<WorkersCompensationRate> wrapper = bullhornData.query(WorkersCompensationRate.class, where, null, queryParams);

        runAssertions("ListWrapper<WorkersCompensationRate>", wrapper);

    }

    @Test
    public void testQueryFile() {

        ListWrapper<File> wrapper = bullhornData.query(File.class, where, null, queryParams);

        runAssertions("ListWrapper<File>", wrapper);

    }

	@Test
	public void testQueryHousingComplexGreaterThan() {

		ListWrapper<HousingComplex> wrapper = bullhornData.query(HousingComplex.class, "id > 10", null, queryParams);

		assertTrue(wrapper.getCount() == 10);
		runAssertions("ListWrapper<HousingComplex>", wrapper);

	}

	@Test
	public void testQueryJobOrderGreaterThan() {

		ListWrapper<JobOrder> wrapper = bullhornData.query(JobOrder.class, "id > 10", null, queryParams);

		assertTrue(wrapper.getCount() == 10);
		runAssertions("ListWrapper<JobOrder>", wrapper);

	}

	@Test
	public void testQueryJobOrderGreaterThanEqualTo() {

		ListWrapper<JobOrder> wrapper = bullhornData.query(JobOrder.class, "id >= 10", null, queryParams);

		assertTrue(wrapper.getCount() == 11);
		runAssertions("ListWrapper<JobOrder>", wrapper);

	}

	@Test
	public void testQueryJobOrderLessThan() {

		ListWrapper<JobOrder> wrapper = bullhornData.query(JobOrder.class, "id < 5", null, queryParams);

		assertTrue(wrapper.getCount() == 4);
		runAssertions("ListWrapper<JobOrder>", wrapper);

	}

	@Test
	public void testQueryJobOrderLessThanEqualTo() {

		ListWrapper<JobOrder> wrapper = bullhornData.query(JobOrder.class, "id <= 5", null, queryParams);

		assertTrue(wrapper.getCount() == 5);
		runAssertions("ListWrapper<JobOrder>", wrapper);

		ListWrapper<JobOrder> wrapper2 = bullhornData.query(JobOrder.class, "status = 'Submitted'", null, queryParams);

		assertTrue(wrapper2.getCount() == 2);

	}

	@Test
	public void testQueryJobOrderEqualTo() {

		ListWrapper<JobOrder> wrapper = bullhornData.query(JobOrder.class, "id = 5", null, queryParams);

		assertTrue(wrapper.getCount() == 1);
		runAssertions("ListWrapper<JobOrder>", wrapper);

	}

	@Test
	public void testQueryJobOrderNotEqualTo() {

		ListWrapper<JobOrder> wrapper = bullhornData.query(JobOrder.class, "id <> 5", null, queryParams);

		assertTrue(wrapper.getCount() == 19);
		runAssertions("ListWrapper<JobOrder>", wrapper);

	}

    @Test
    public void testQueryJobBoardPost() {

        ListWrapper<JobBoardPost> wrapper = bullhornData.query(JobBoardPost.class, where, null, queryParams);
        runAssertions("ListWrapper<JobBoardPost>", wrapper);

    }

	@Test
	public void testQueryJobSubmission() {

		ListWrapper<JobSubmission> wrapper = bullhornData.query(JobSubmission.class, where, null, queryParams);
		runAssertions("ListWrapper<JobSubmission>", wrapper);

	}

	@Test
	public void testQueryJobSubmissionHistory() {

		ListWrapper<JobSubmissionHistory> wrapper = bullhornData.query(JobSubmissionHistory.class, where, null, queryParams);
		runAssertions("ListWrapper<JobSubmissionHistory>", wrapper);

	}

    @Test
    public void testQueryLead() {

        ListWrapper<Lead> wrapper = bullhornData.query(Lead.class, where, null, queryParams);

        runAssertions("ListWrapper<Lead>", wrapper);
    }

	@Test
	public void testQueryNoteEntity() {

		ListWrapper<NoteEntity> wrapper = bullhornData.query(NoteEntity.class, where, null, queryParams);

		runAssertions("ListWrapper<Note>", wrapper);
	}

    @Test
    public void testQueryOpportunity() {

        ListWrapper<Opportunity> wrapper = bullhornData.query(Opportunity.class, where, null, queryParams);

        runAssertions("ListWrapper<Opportunity>", wrapper);
    }

	@Test
	public void testQueryPlacement() {

		ListWrapper<Placement> wrapper = bullhornData.query(Placement.class, where, null, queryParams);

		runAssertions("ListWrapper<ClientContact>", wrapper);

	}

    @Test
    public void testQueryPlacementCertification() {

        ListWrapper<PlacementCertification> wrapper = bullhornData.query(PlacementCertification.class, where, null, queryParams);

        runAssertions("ListWrapper<PlacementCertification>", wrapper);

    }

	@Test
	public void testQueryPlacementChangeRequest() {

		ListWrapper<PlacementChangeRequest> wrapper = bullhornData.query(PlacementChangeRequest.class, where, null, queryParams);

		runAssertions("ListWrapper<PlacementChangeRequest>", wrapper);

	}

	@Test
	public void testQueryPlacementCommission() {

		ListWrapper<PlacementCommission> wrapper = bullhornData.query(PlacementCommission.class, where, null, queryParams);

		runAssertions("ListWrapper<PlacementCommission>", wrapper);

	}

	@Test
	public void testQueryPlacementCommission_2() {

		String query = "placement.id=" + testEntities.getPlacementId() + " AND user.id IS NOT NULL";
		ListWrapper<PlacementCommission> wrapper = bullhornData.query(PlacementCommission.class, query, null, queryParams);

		runAssertions("ListWrapper<PlacementCommission>", wrapper);

	}

	@Test
	public void testQuerySendout() {

		ListWrapper<Sendout> wrapper = bullhornData.query(Sendout.class, where, null, queryParams);

		runAssertions("ListWrapper<Sendout>", wrapper);

	}

	@Test
	public void testQuerySkill() {

		ListWrapper<Skill> wrapper = bullhornData.query(Skill.class, where, null, queryParams);

		runAssertions("ListWrapper<Skill>", wrapper);

	}

	@Test
	public void testQuerySpecialty() {

		ListWrapper<Specialty> wrapper = bullhornData.query(Specialty.class, where, null, queryParams);

		runAssertions("ListWrapper<Specialty>", wrapper);

	}

	@Test
	public void testQueryState() {

		ListWrapper<State> wrapper = bullhornData.query(State.class, where, null, queryParams);

		runAssertions("ListWrapper<State>", wrapper);

	}

	@Test
	public void testQueryTask() {

		ListWrapper<Task> wrapper = bullhornData.query(Task.class, where, null, queryParams);

		runAssertions("ListWrapper<Task>", wrapper);

	}

	@Test
	public void testQueryTimeUnit() {

		ListWrapper<TimeUnit> wrapper = bullhornData.query(TimeUnit.class, where, null, queryParams);

		runAssertions("ListWrapper<TimeUnit>", wrapper);

	}

    @Test
    public void testQueryUserType() {

        ListWrapper<UserType> wrapper = bullhornData.query(UserType.class, where, null, queryParams);

        runAssertions("ListWrapper<UserType>", wrapper);

    }

	private <T extends BullhornEntity> void runAssertions(String wrapperName, ListWrapper<T> wrapper) {
		assertNotNull(wrapperName + " is null", wrapper);
		assertNotNull(wrapperName + ".data is null", wrapper.getData());
		assertTrue(wrapperName + ".data is empty", wrapper.getData() != null && wrapper.getData().size() > 0);
		assertTrue(wrapperName + ".data.size() is not equal to count", wrapper.getData().size() == wrapper.getCount());
	}

}