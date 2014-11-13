package nl.ing.opendialogue.controller;

import java.util.Arrays;
import java.util.List;

import nl.ing.opendialogue.domain.DialogueResponse;
import nl.ing.opendialogue.domain.MakePhoneCallState;
import nl.ing.opendialogue.domain.QuestionForCustomer;
import nl.ing.opendialogue.domain.QuestionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportFoundCardToCardOwnerController {

	@Autowired
	private MakePhoneCallState makePhoneCallState;

	@RequestMapping(value = "/report-card-to-owner", method = RequestMethod.POST)
	public DialogueResponse blockFoundCardQuestions(@RequestBody String blockCardConfirm) {

		if (!StringUtils.isEmpty(blockCardConfirm)
				&& Boolean.parseBoolean(blockCardConfirm)) {

			makePhoneCallState.setMakePhoneCall(true);
			
			QuestionForCustomer question1 = new QuestionForCustomer();
			question1.setStep("1");
			question1.setQuestion("Bedankt. U krijgt snel een nieuwe pas toegestuurd");
			List<QuestionForCustomer> questions = Arrays.asList(question1);
			DialogueResponse response = new DialogueResponse(questions);
			response.setContextUrl("/answer");

			return response;
		}
		QuestionForCustomer question1 = new QuestionForCustomer();
		question1.setStep("1");
		question1.setQuestion("Bedankt. Wij zullen dan geen verdere actie ondernemen");
		List<QuestionForCustomer> questions = Arrays.asList(question1);
		DialogueResponse response = new DialogueResponse(questions);
		response.setContextUrl("/answer");

		return response;
	}

	@RequestMapping(value = "/report-card-to-owner", method = RequestMethod.GET)
	public DialogueResponse blockFoundCard() {

		QuestionForCustomer question1 = new QuestionForCustomer();
		question1.setStep("1");
		question1.setParameterName("blockCardConfirm");
		question1
				.setQuestion("Goededag welkom bij de ING. Wij hebben een melding gekregen dat uw pas is gevonden. Wilt u een nieuwe pas hebben?");
		question1.setType(QuestionType.ALPHANUMERIC);
		List<QuestionForCustomer> questions = Arrays.asList(question1);
		DialogueResponse response = new DialogueResponse(questions);
		response.setContextUrl("/report-card-to-owner");

		return response;
	}

}
