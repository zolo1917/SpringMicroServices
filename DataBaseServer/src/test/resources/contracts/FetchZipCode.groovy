package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make{
	description : "this is a test script"
	request {
		url "/getCityState/45202"
		method GET()
	}

	response {
		status OK()
		headers {
			contentType applicationJson()
		}
		body (
			zip: 45202,
			city: "Cincinnati",
			stateId: "OH",
			stateName: "Ohaio",
			countyName: "Hamilton"
		)
	}
	
	
}

